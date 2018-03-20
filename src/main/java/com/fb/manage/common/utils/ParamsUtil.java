package com.fb.manage.common.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**   
* @Title: ParamsUtil.java 
* @Package mob.util 
* @Description:  
* @author 王晓鹏
* @date 2015年1月12日 上午10:03:18 
* @version V1.0   
*/
public class ParamsUtil {

	public static String getStrParamter(Map<String, Object> reqMap, String name) {

		Object obj = reqMap.get(name);
		if (obj == null) {
			return null;
		}
		if (obj instanceof Object[]) {
			if (obj instanceof String[]) {
				String values[] = (String[]) obj;
				if (values.length > 0 && values[0] != null
						&& !values[0].trim().equals("")) {
					return values[0];
				}

			} else if (obj instanceof Integer[]) {
				Integer values[] = (Integer[]) obj;
				if (values.length > 0 && values[0] != null) {
					return String.valueOf(values[0].intValue());
				}
			} else if (obj instanceof Double[]) {
				Double values[] = (Double[]) obj;
				if (values.length > 0 && values[0] != null) {
					return String.valueOf(values[0].doubleValue());
				}
			} else if (obj instanceof Long[]) {
				Long values[] = (Long[]) obj;
				if (values.length > 0 && values[0] != null) {
					return String.valueOf(values[0].longValue());
				}
			} else if (obj instanceof BigDecimal[]) {
				BigDecimal values[] = (BigDecimal[]) obj;
				if (values.length > 0 && values[0] != null) {
					return String.valueOf(values[0].doubleValue());
				}
			}else if (obj instanceof Date[]) {
				Date values[] = (Date[]) obj;
				if (values.length > 0 && values[0] != null) {
					return values[0].toString();
				}
			} else {
				Object values[] = (Object[]) obj;
				if (values.length > 0 && values[0] != null) {
					return values[0].toString();
				}
			}

		}else{
			if (obj instanceof String) {
				return obj.toString();
			} else if (obj instanceof Integer) {
				return String.valueOf(((Integer)obj).intValue());
			} else if (obj instanceof Double) {
				return String.valueOf(((Double)obj).doubleValue());
			} else if (obj instanceof Long) {
				return String.valueOf(((Long)obj).longValue());
			} else if (obj instanceof BigDecimal) {
				return String.valueOf(((BigDecimal)obj).doubleValue());
			} else if (obj instanceof Date) {
				return ((Date) obj).toString();
			}else {
				return obj.toString();
			}
		}

		return null;
	}
	
	
	

	public static Object getObjParamter(Map<String, Object> reqMap, String name) {
		Object obj = reqMap.get(name);
		if (obj == null) {
			return null;
		}
		if (obj instanceof Object[]) {
			Object values[] = (Object[]) obj;
			if (values.length > 0 && values[0] != null) {
				return values[0];
			}else{
				return null;
			}

		}else{
			return obj;
		}
	}




	public static Object getStrParamter(Map userAk, String upperCase,
			String strParamter, String string, String buy_amt, String uf_mob,
			String string2, String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
