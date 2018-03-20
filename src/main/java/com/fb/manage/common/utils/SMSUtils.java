package com.fb.manage.common.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 短信工具类
 * @author slc
 */
public class SMSUtils {
    private static Logger log = LoggerFactory.getLogger(SMSUtils.class);

    private static final String cloudfengUrl = PropertiesUtils.getValueIgnoreEncrypt("cloudfeng.url");
    private static final String cloudfengTitle = PropertiesUtils.getValueIgnoreEncrypt("cloudfeng.title");
    private static final String cloudfengAppKey = PropertiesUtils.getValueIgnoreEncrypt("cloudfeng.appKey");
    private static final String cloudfengAppSecret = PropertiesUtils.getValueIgnoreEncrypt("cloudfeng.appSecret");
    private static final String cloudfengNonceStr = PropertiesUtils.getValueIgnoreEncrypt("cloudfeng.nonceStr");

    public static void main(String[] args) throws IOException {
//        sendSms("13664251357", "您正在进行短信验证，验证码为000001,五分钟内有效，为确保您的账户安全，请勿向任何人泄露您的验证码。如非本人操作请致电：1111-1111-11", "verify_code");
    	String generateInfo = SMSInfoUtils.generateInfo(SMSInfoUtils.TYPEPHONECODE,
				"000000");
    	System.out.println(generateInfo);
    }


    /**
     * 发短信方法
     * @param phone 手机号
     * @param contents  内容
     * @param smsType verify_code 验证码类，notice  通知类， advert 营销类
     * @return
     * @throws IOException
     */
    public static boolean sendSms(String phone, String contents, String smsType) throws IOException {
        log.info("----------------------短信接口开始----------------------");
        boolean boolStatus = false;
        contents += "";
        // 短信开关
        String key = PropertiesUtils.getValueIgnoreEncrypt("smsKey");
        if ("1".equals(key)) {
            log.info("短信通道=云风");
            int re = sendCloudfeng(smsType, phone, contents);
            log.info("畅天游接口返回值=" + re);
            if (re == 1) {
                boolStatus = true;
            } else {
                boolStatus = false;
            }
        } else if ("-1".equals(key)) {
            log.info("短信通道=虚拟通道");
            boolStatus = true;
        }

        log.info("短信发送状态=" + boolStatus);
        log.info("----------------------短信接口结束----------------------");
        return boolStatus;
    }

    /**
     * 发送短信（云风）
     *
     * @param smsType verify_code 验证码类，notice  通知类， advert 营销类
     * @param mobiles 手机号（多个用","分隔）
     * @param content 内容
     * @return
     */
    public static int sendCloudfeng(String smsType, String mobiles, String content) {
        String response = null;
        try {
            response = HttpClientUtil.doPost(cloudfengUrl, getXmlInfo(mobiles, content, smsType));
            log.info("[云风短信] 手机号：[{}], 内容：{}", mobiles, content);
            SAXReader reader = new SAXReader();
            Document document = reader.read(new ByteArrayInputStream(response.getBytes("UTF-8")));
            Element root = document.getRootElement();
            List<Element> childElements = root.elements();
            String errorCode = "";
            String errorMsg = "";
            for (Element child : childElements) {//循环输出全部book的相关信息
                List<Element> eles = child.elements();
                for (Element ele : eles) {
                    if ("error_code".equals(ele.getName())) {
                        errorCode = ele.getText();
                        break;
                    }
                    if ("error_msg".equals(ele.getName())) {
                        errorMsg = ele.getText();
                    }
                }
            }
            if ("000000".equals(errorCode)) {
                return 1;
            }
            log.info("[云风短信] 手机号：[{}], 内容：{}，返回码：{}, 返回消息：{}", mobiles, content, errorCode, errorMsg);
            return 0;
        } catch (Exception e) {
            log.info("[云风短信] 手机号：[{}], 返回：{}", mobiles, response);
            return 0;
        }
    }

    /**
     *
     * @param dest_id 手机号（多个用","分隔）
     * @param content 内容
     * @return
     */
    private static String getXmlInfo(String dest_id, String content, String smsType) {
        Date date = new Date();
        //时间戳
        String time_stamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        //批次号  以后改成自动的
        String batch_num = cloudfengNonceStr + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date);
        //手机号，可以多个，
        String[] dest_id_array = dest_id.split(",");
        //手机号对应个number
        String mission_num[] = new String [dest_id_array.length];

        //短信类别   两种方案1：写逻辑做判断
        //         2：用户自己填写
        String sms_type=smsType;

        //为MD5加密使用
        String dest_id_md5="";
        String mission_num_md5="";

        //拼接XML
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<xml>");
        sb.append("<head>");
        sb.append("<app_key>"+cloudfengAppKey+"</app_key>");
        sb.append("<time_stamp>"+time_stamp+"</time_stamp>");
        sb.append("<nonce_str>"+cloudfengNonceStr+"</nonce_str>");

        for(int i=0;i<dest_id_array.length;i++){
            //0 代表前面补充0, 8代表长度为8,d 代表参数为正数型
            String str = String.format("%08d", i);
            mission_num[i]="straycat"+str;
            dest_id_md5=dest_id_md5+"&dest_id="+dest_id_array[i];
            mission_num_md5=mission_num_md5+"&mission_num="+mission_num[i];
        }
        //计算sign
        String md="app_key="+cloudfengAppKey+"&batch_num="+batch_num+"&content="+"【"+cloudfengTitle+"】"
                +content+dest_id_md5+mission_num_md5+"&nonce_str="+cloudfengNonceStr+"&sms_type="+
                sms_type+"&time_stamp="+time_stamp+"&app_secret="+cloudfengAppSecret;
        log.info(md);

        String sign = StringUtils.MD5(md);
        System.out.println(sign);
        sb.append("<sign>"+sign+"</sign>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<dests>");
        for(int i=0; i < dest_id_array.length; i++){
            sb.append("<dest>");
            sb.append("<mission_num>"+mission_num[i]+"</mission_num>");
            sb.append("<dest_id>"+dest_id_array[i]+"</dest_id>");
            sb.append("</dest>");
        }
        sb.append("</dests>");
        sb.append("<batch_num>"+batch_num+"</batch_num>");
        sb.append("<sms_type>"+sms_type+"</sms_type>");
        sb.append("<content>"+"【"+cloudfengTitle+"】"+content+"</content>");
        sb.append("</body>");
        sb.append("</xml>");
        return sb.toString();
    }

    public static boolean sendYYSms(String mobile, String random) {
        return true;
    }
    
   
}
