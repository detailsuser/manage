package com.fb.manage.common.utils.phoneCodeUtils;


import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * 018-1-11
 * (1)去除验证码类型枚举   验证码类型枚举迁移到业务层进行定义
 * (2)去除发送验证码时对验证码类型的检测  类型检测由业务方法实现
 * (3)修改发送内容由调用者提供  方法增加发送内容  String sendCode
 */

/**
 * 手机验证码工具类   自带缓存
 * 用于发送，缓存，检验手机短信验证码
 * 缓存的清除：设定一个清理值，当外部调用检验手机短信验证码达到该值得时候，开启一个清理线程，清除掉过期未检验的无效验证码缓存
 * @createDate : 2017/11/9 15:09
 * @ceeateName : MEINANZI
 */
public class PhoneCodeUtil {

    //请求接口地址
    private static final String REQUEST_URL = "http://v.juhe.cn/sms/send";

    //请求的参数
    /**
     * 短信模板ID，请参考个人中心短信模板设置
     */
    private static final String TPI_ID = "44665";
    /**
     * 返回数据的格式,xml或json，默认json
     */
    private static final String DTYPE = "json";
    /**
     * 申请的KEY   应用APPKEY
     */
    private static final String APPKEY ="9f596fd7e5a61dba86fb6abeba8ca978";

    //连接的的一些参数
    private static final String DEF_CHATSET = "UTF-8";
    private static final int DEF_CONN_TIMEOUT = 30000;
    private static final int DEF_READ_TIMEOUT = 30000;
    private static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    /**
     * 存储手机验证码<br/>
     * key  手机号<br/>
     * value  用户的手机验证码缓存
     */
    private static ConcurrentMap<String,PhoneCodeCache> phoneCodeCaches;
    static {
        phoneCodeCaches = new ConcurrentHashMap<String,PhoneCodeCache>();
    }


    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 发送手机验证码
     * @param phone   手机号码
     * @param pCTE  phoneCodeTypeEnum手机验证码的类型枚举
     * @param sendCode  发送内容
     * @return success 成功
     * @throws Exception
     */
    public static String sendPhoneCode(String phone, Enum pCTE, String sendCode) throws Exception {
        PhoneCodeCache phoneCodeCache;  //用户的手机验证码 缓存对象
        //获取用户验证码缓存
        if((phoneCodeCache = phoneCodeCaches.get(phone)) == null){  //缓存不存在
            //创建一个空缓存
            phoneCodeCaches.put(phone,(phoneCodeCache = new PhoneCodeCache()));
        }else{  //缓存存在
            //缓存中是否存在同一类型的处于有效的验证码
            PhoneCodeCache.PhoneCode phoneCode;
            if ((phoneCode = phoneCodeCache.get(pCTE)) != null && !phoneCode.isReSend()){
                //请求验证码的间隔太短
                return PhoneCodeErrorInfo.ERROR_PHONECODE_SEND_INTERVAL_SHORT.name();
            }
        }

        //发送验证码
        _sendPhoneCode(phone,sendCode);
        //放入缓存
        phoneCodeCache.set(pCTE,sendCode);
        return "success";
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    /**
     * 比对手机验证码
     * @param phone  手机号码
     * @param pCT  手机验证码类型
     * @param phoneCode  验证码
     * @return success 验证码比对正确
     */
    public static String checkPhoneCode(String phone, Enum pCT, String phoneCode) {
//        return "success";
        //验证码缓存
        PhoneCodeCache phoneCodeCache;
        //验证码
        PhoneCodeCache.PhoneCode code;

        //取出用户手机验证码
        if ((phoneCodeCache = phoneCodeCaches.get(phone)) == null || (code = phoneCodeCache.get(pCT)) == null ){
            //用户验证码缓存为空  表示用户还没有获取过验证码  ||  用户手机验证码为空  表示没有获取过验证码
            return "请先获取手机验证码";
        }
        //检查验证码是否已过期
        if(code.isEffective()){   //验证码还没有过期  有效
            //比对验证码
            if (code.getPhoneCode().equals(phoneCode)){
                //验证码正确    移除验证码
                phoneCodeCache.remove(pCT);
                return "success";
            }
            //验证码错误
            return "验证码错误";
        }else{
            //已过期未清理的验证码   已失效  需要用户重新获取
            phoneCodeCache.remove(pCT);
            return "验证码已过期,请重新获取";
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------



    /**
     * 发送手机验证码
     * @param phone   手机号码
     * @param phoneCode   要发送的手机验证码
     * @return success 成功
     * @throws Exception
     */
    private static boolean _sendPhoneCode(String phone, String phoneCode) throws Exception {
        String result =null;
        String tpl_value = URLEncoder.encode("#code#=" + phoneCode,"UTF-8");

        Map params = new HashMap();//请求参数
        params.put("mobile",phone);//接收短信的手机号码
        params.put("tpl_value",tpl_value);//键值对
        params.put("tpl_id",TPI_ID);//短信模板id
        params.put("key",APPKEY);//应用key
        params.put("dtype",DTYPE);//返回值格式

        result = _net(REQUEST_URL, params, "GET");
        JSONObject object = JSONObject.fromObject(result);  //解析字符串
        //获取错误码   如果为0 表示发送短信成功
        if(object.getInt("error_code")!=0){
            //发送失败
            return false;
        }
        return true;
    }


    /**
     * 连接短信请求地址   并  读取请求返回数据
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return  请求返回的字符串
     * @throws Exception
     */
    private static String _net(String strUrl, Map params,String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if(method==null || method.equals("GET")){
                strUrl = strUrl+"?"+urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if(method==null || method.equals("GET")){
                conn.setRequestMethod("GET"); //设置请求方式为  get方式
            }else{
                conn.setRequestMethod("POST");//设置请求方式为  post 方式
                conn.setDoOutput(true);
            }
            //写入一些定义好的变量
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            //连接发送
            conn.connect();
            if (params!= null && method.equals("POST")) {
                try {//post  发送数据
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();  //获取输入流
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));  //将输入流写入到缓存区等待解读
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {  //解读返回的数据
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("请求手机验证码发送错误",e);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    //-----------------------------------------------------------------------------------------------------------------------------

    //将map型转为请求参数型
    public static String urlencode(Map<String,Object>data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    //-----------------------------------------------------------------------------------------------------------------------------
    /**
    * @Author: lcc
    * @Description: 测试短信
    * @Date: 14:19 2018/3/21
    * @params  * @param null
    */
    public static void main(String[] args) {
        try {
            _sendPhoneCode("15155849950","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

