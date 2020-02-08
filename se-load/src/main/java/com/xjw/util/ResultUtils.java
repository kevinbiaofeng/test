package com.xjw.util;

import com.alibaba.fastjson.JSONObject;

public class ResultUtils {
	
	public static JSONObject toJson(boolean success, String msg){
		return toJson(success, null, msg, null);
	}
	
	public static JSONObject toJson(boolean success, String code, String msg){
		return toJson(success, code, msg, null);
	}
	
	public static <T> JSONObject toJson(boolean success, T model){
		return toJson(success, null, null, model);
	}
	
	public static <T> JSONObject toJson(boolean success, String code, String msg, T model){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", success);
		jsonObject.put("code", code);
		jsonObject.put("msg", msg);
		jsonObject.put("model", model);
		return jsonObject;
	}
}
