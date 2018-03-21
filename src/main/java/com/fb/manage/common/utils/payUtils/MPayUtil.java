package com.fb.manage.common.utils.payUtils;//package com.fanpay.utils.payUtils;
//
//import models.aLiPayInfo;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//
//public class MPayUtil {
//
//
//	public static Map<String, String> buildOrderParamMap2(String userid ,String total_amount, boolean rsa2) {
//		Map<String, String> keyValues = new HashMap<String, String>();
//		String order_no = getOutTradeNo();
//		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//		keyValues.put("app_id", Contans.APPID);
//
////		keyValues.put("method", "alipay.trade.app.pay");
//		keyValues.put("method", "alipay.trade.wap.pay");
//
//		keyValues.put("format", "JSON");
//
//		keyValues.put("charset", "utf-8");
//
//		keyValues.put("sign_type", "RSA2");
//
//		keyValues.put("notify_url" , "http://47.93.191.121:9000/notify_url");
//
//		keyValues.put("timestamp", time);
//
//		keyValues.put("version", "1.0");
//
//		keyValues.put("biz_content", "{\"total_amount\":\""+Double.parseDouble(total_amount)+"\",\"subject\":\"支付宝充值\",\"body\":\"泛贝充值\",\"out_trade_no\":\"" + order_no +  "\"}");
//
//		aLiPayInfo aLiPayInfos =new aLiPayInfo();
//		aLiPayInfos.userinfo_id = userid ;
//		aLiPayInfos.out_trade_no= order_no;
//		aLiPayInfos.total_amount = Double.parseDouble(total_amount) ;
//		aLiPayInfos.trade_status = "未支付";
//		aLiPayInfos.gmt_create = time;
//		aLiPayInfo  aLiPayInfo =aLiPayInfos.save();
//		if(aLiPayInfo==null){
//			return null;
//		}
//
//		return keyValues;
//	}
//
//	/**
//	 * 构造支付订单参数信息
//	 *
//	 * @param map
//	 * 支付订单参数
//	 * @return
//	 */
//	public static String buildOrderParam(Map<String, String> map) {
//		List<String> keys = new ArrayList<String>(map.keySet());
//
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < keys.size() - 1; i++) {
//			String key = keys.get(i);
//			String value = map.get(key);
//			sb.append(buildKeyValue(key, value, true));
//			sb.append("&");
//		}
//
//		String tailKey = keys.get(keys.size() - 1);
//		String tailValue = map.get(tailKey);
//		sb.append(buildKeyValue(tailKey, tailValue, true));
//
//		return sb.toString();
//	}
//
//	/**
//	 * 拼接键值对
//	 *
//	 * @param key
//	 * @param value
//	 * @param isEncode
//	 * @return
//	 */
//	private static String buildKeyValue(String key, String value, boolean isEncode) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(key);
//		sb.append("=");
//		if (isEncode) {
//			try {
//				sb.append(URLEncoder.encode(value, "UTF-8"));
//			} catch (UnsupportedEncodingException e) {
//				sb.append(value);
//			}
//		} else {
//			sb.append(value);
//		}
//		return sb.toString();
//	}
//
//	/**
//	 * 对支付参数信息进行签名
//	 *
//	 * @param map
//	 *            待签名授权信息
//	 *
//	 * @return
//	 */
//	public static String getSign(Map<String, String> map, String rsaKey, boolean rsa2) {
//		List<String> keys = new ArrayList<String>(map.keySet());
//		// key排序
//		Collections.sort(keys);
//
//		StringBuilder authInfo = new StringBuilder();
//		for (int i = 0; i < keys.size() - 1; i++) {
//			String key = keys.get(i);
//			String value = map.get(key);
//			authInfo.append(buildKeyValue(key, value, false));
//			authInfo.append("&");
//		}
//
//		String tailKey = keys.get(keys.size() - 1);
//		String tailValue = map.get(tailKey);
//		authInfo.append(buildKeyValue(tailKey, tailValue, false));
//
//		String oriSign = SignUtils.sign(authInfo.toString(), rsaKey, rsa2);
//		String encodedSign = "";
//
//		try {
//			encodedSign = URLEncoder.encode(oriSign, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return "sign=" + encodedSign;
//	}
//
//	/**
//	 * 要求外部订单号必须唯一。
//	 * @return
//	 */
//	private static String getOutTradeNo() {
//		SimpleDateFormat format = new SimpleDateFormat("MMddHHmmss", Locale.getDefault());
//		Date date = new Date();
//		String key = format.format(date);
//
//		Random r = new Random();
//		key = key + r.nextInt();
//		key = key.substring(0, 15);
//		return key;
//	}
//}
