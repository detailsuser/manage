package com.fb.manage.common.utils;


/**
 * 获取Properties参数工具类
 * @author lh
 *
 */
public class PropertiesUtils {
	private static PropertiesLoader propertiesLoader = new PropertiesLoader("application.properties");
	/**
	 * 参数是否加密
	 * 获取加密参数 propEncrypt=1
	 * 获取明文参数 propEncrypt=0
	 */

	/**
	 * 根据key获取值
	 * @param key
	 * @return
	 */
	public static String getValue(String key) {
		String property = propertiesLoader.getProperty(key);

		return property;
	}
	
	/**
	 * 忽略加密直接获取参数值
	 * @param key
	 * @return
	 */
	public static String getValueIgnoreEncrypt(String key) {
		return propertiesLoader.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(PropertiesUtils.getValue("smsKey"));
		System.out.println(PropertiesUtils.getValue("keyCer"));
		System.out.println(PropertiesUtils.getValue("keyStore"));
		System.out.println(PropertiesUtils.getValue("notify_url"));
		System.out.println(PropertiesUtils.getValue("ftpHost"));
	}
}
