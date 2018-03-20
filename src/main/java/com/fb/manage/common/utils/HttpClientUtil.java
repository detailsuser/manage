package com.fb.manage.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.expression.ParseException;

import com.alibaba.fastjson.JSONObject;

public class HttpClientUtil {
	public static String doPost(String url,Map<String,String> map,String charset){  
        HttpClient httpClient = null;  
        HttpPost httpPost = null;  
        String result = null;  
        try{  
            httpClient = new SSLClient();  
            httpPost = new HttpPost(url);  
            //设置参数  
            List<NameValuePair> list = new ArrayList<NameValuePair>();  
            Iterator iterator = map.entrySet().iterator();  
            while(iterator.hasNext()){  
                Entry<String,String> elem = (Entry<String, String>) iterator.next();  
                list.add(new BasicNameValuePair(elem.getKey(),elem.getValue()));  
            }  
            if(list.size() > 0){  
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,charset);  
                httpPost.setEntity(entity);  
            }  
            HttpResponse response = httpClient.execute(httpPost);  
            if(response != null){  
                HttpEntity resEntity = response.getEntity();  
                if(resEntity != null){  
                    result = EntityUtils.toString(resEntity,charset);  
                }  
            }  
        }catch(Exception ex){  
            ex.printStackTrace();  
        }  
        return result;  
    }  
	
	public static String doPost(String url, String parameters) {  
        HttpClient httpClient = null;
        HttpPost method = null;
        try {  
        	httpClient = new SSLClient();
        	method = new HttpPost(url);
            // 建立一个NameValuePair数组，用于存储欲传送的参数  
            method.addHeader("Content-type","application/json; charset=utf-8");  
            method.setHeader("Accept", "application/json");  
            method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));  
            HttpResponse response = httpClient.execute(method);  
            return EntityUtils.toString(response.getEntity());  
        } catch (Exception e) {  
            e.printStackTrace();
        }
        return null;  
    }
	
	public static String upload(String url, String fileKey, File file, JSONObject params) {  
        HttpClient client = null;
        HttpPost httpPost = null;
        try {  
        	client = new SSLClient();
        	httpPost = new HttpPost(url);
        	client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);  
        	client.getParams().setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, "utf-8");  
            MultipartEntity entity = new MultipartEntity();  
            // 文件参数部分  
            ContentBody fileBody = new FileBody(file); // file  
            entity.addPart(fileKey, fileBody);  
            // 字符参数部分  
            Set<String> set = params.keySet();  
            for (String key : set) {  
                entity.addPart(key, new StringBody(params.getString(key)));  
            }  
            httpPost.setEntity(entity);  
            HttpResponse response = client.execute(httpPost);
            return EntityUtils.toString(response.getEntity());  
        } catch (Exception e) {  
            e.printStackTrace();
        }  
        return null;
    } 
	
	/**
	 * 发送HTTP_POST请求
	 * 
	 * @Description
	 * @author jay
	 * @date 2013-8-8 下午12:23:52
	 * @param reqURL
	 * @param params
	 * @return
	 */
	public static String sendPostRequest(String reqURL, Map<String, String> params) {
		String responseContent = null; // 响应内容
		HttpClient httpClient = new DefaultHttpClient(); // 创建默认的httpClient实例
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 1000*60*10); // 连接超时10s
		httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000*60*10); // 读取超时20s
		HttpPost httpPost = new HttpPost(reqURL); // 创建org.apache.http.client.methods.HttpPost
		List<NameValuePair> formParams = new ArrayList<NameValuePair>(); // 创建参数队列
		for (Entry<String, String> entry : params.entrySet()) {
			formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue())); // 参数构建
		}
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8")); // 设置参数字符集
			HttpResponse response = httpClient.execute(httpPost);// 执行 Post请求
			HttpEntity entity = response.getEntity(); // 获取响应实体
			if (null != entity) {
				responseContent = EntityUtils.toString(entity, "UTF-8");
				EntityUtils.consume(entity);
			}
		} catch (ConnectTimeoutException cte) {
			System.out.println("请求通信[" + reqURL + "]时连接超时");
			cte.printStackTrace();
		} catch (SocketTimeoutException ste) {
			System.out.println("请求通信[" + reqURL + "]时读取超时");
			ste.printStackTrace();
		} catch (ClientProtocolException cpe) {
			System.out.println("请求通信[" + reqURL + "]时协议异常");
			cpe.printStackTrace();
		} catch (ParseException pe) {
			System.out.println("请求通信[" + reqURL + "]时解析异常");
			pe.printStackTrace();
		} catch (IOException ioe) {
			System.out.println("请求通信[" + reqURL + "]时网络异常");
			ioe.printStackTrace();
		} catch (Exception e) {
			System.out.println("请求通信[" + reqURL + "]时偶遇异常");
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			httpClient.getConnectionManager().shutdown();
		}
		return responseContent;
	}

	public static void main(String[] args) {
		doPost("http://127.0.0.1:8080/juhcao_admin/juchao/borrow/notify", "{\"oid_partner\": \"201603210000114005\",     \"partner_project_id\": \"2016070611547681323211215\",     \"project_auditstate\": \"P\",     \"sign\": \"d+GNGC1FeHOwOiHTc0AEzjpz+2eUSuVAeS1bWdLUFU55DStemogChbj3b+TZsFPp3upfqiisfgXQWHMNdWfrPreaUd0E5iN3xeOdtFOb74ajFzXgKSChMtnc7Q/a0ADmpdGokI1fq2mQMLHWxov2khB7Nf1Jt2n+lxFj4O7jkxo=\",     \"sign_type\": \"RSA\" }");
	}
	
}
