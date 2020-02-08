package com.xjw.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.xjw.kzenum.RestServiceErrorEnum;

public class JSONDataValidator {
	private static Logger logger= LoggerFactory.getLogger(JSONDataValidator.class.getName());
	/**
	 * 验证数据是否合法
	 * @param jsonData
	 * @param obj
	 * @param jsonObj
	 * @return
	 */
	public static JSONObject JSONDataFormatVali(String jsonData, Object obj, JSONObject jsonObj){
		try {
			obj = JSON.parseObject(jsonData, obj.getClass());
			jsonObj.put("code", "1");
		} catch (JSONException e) {
			logger.error(e.getMessage(), e);
			jsonObj.put("code", "0");
			jsonObj.put("data", RestServiceErrorEnum.FORMAT.getName());
		}
		return jsonObj;
	}
	
	/**
	 * 验证token是否正确
	 * @param jsonData
	 * @param obj
	 * @param jsonObj
	 * @return
	 */
	public static JSONObject JSONDataTokenVali(String token, String getToken, JSONObject jsonObj){
		if(token.equals(getToken)){
			jsonObj.put("code", "1");
		}else{
			jsonObj.put("code", "0");
			jsonObj.put("data", RestServiceErrorEnum.TOKEN.getName());
		}
		return jsonObj;
	}
}
