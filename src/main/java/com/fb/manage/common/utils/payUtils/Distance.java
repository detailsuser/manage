package com.fb.manage.common.utils.payUtils;

import com.fb.manage.common.utils.httpUtils.HttpRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class Distance {
	
	public static String fingAddress(String address) {
		String addressStr = "http://restapi.amap.com/v3/geocode/geo";
	 	String getAddress = HttpRequest.sendPost(addressStr, "key=796651eb01b9323db28caf2201be2f31&output=JSON&address=" + address);
        JSONObject object = JSONObject.fromObject(getAddress);
        JSONArray geocodes = object.getJSONArray("geocodes");
        if (geocodes.size() == 1) {
            JSONObject trueAddress = geocodes.getJSONObject(0);
            String location = trueAddress.getString("location");
            String lngX = location.split(",")[0];
            String latY = location.split(",")[1];
            return location;
        }else{
        	return null;
        }
    }
}
