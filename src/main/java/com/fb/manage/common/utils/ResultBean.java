package com.fb.manage.common.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回的结果集
 * @author lh
 *
 */
public class ResultBean extends HashMap<String, Object> implements Serializable{

	
	
	
	/**
	 * 成功带数据返回
	 * @param key
	 * @param data
	 * @return
	 */
	public static ResultBean ok(String key,Object data){
		ResultBean bean = new ResultBean();
		
		bean.put("success", true);
		bean.put("msg", "");
		bean.put(key, data);
		
		return bean;
	}
	/**
	 * 成功无数据
	 * @return
	 */
	public static ResultBean ok(){
		ResultBean bean = new ResultBean();
		
		bean.put("success", true);
		bean.put("msg", "");
		
		return bean;
	}
	public static ResultBean ok(Map<String,Object> map){
		ResultBean bean = new ResultBean();
		bean.put("success", true);
		bean.put("msg", "");
		for (Entry<String, Object> iterable_element : map.entrySet()) {
			String key = iterable_element.getKey();
			Object value = iterable_element.getValue();
			bean.put(key, value);
		}
		return bean;
	}
	public static ResultBean fail(String msg){
		ResultBean bean = new ResultBean();
		bean.put("success", false);
		bean.put("msg", msg);
		return bean;
	}
	public static ResultBean fail(String msg,Map<String,Object> map){
		ResultBean bean = new ResultBean();
		bean.put("success", false);
		bean.put("msg", msg);
		for (Entry<String, Object> iterable_element : map.entrySet()) {
			String key = iterable_element.getKey();
			Object value = iterable_element.getValue();
			bean.put(key, value);
		}
		return bean;
	}
	public static ResultBean fail(String msg,String key,Object data){
		ResultBean bean = new ResultBean();
		bean.put("success", false);
		bean.put("msg", msg);
		bean.put(key, data);
		return bean;
	}
}
