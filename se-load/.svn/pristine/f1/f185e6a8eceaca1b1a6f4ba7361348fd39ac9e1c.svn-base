package com.xjw.utility;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.alibaba.fastjson.JSONObject;


public final class Security {
	/**
	 * 构建签名原文
	 * 
	 * @param signFilds
	 * @param packet
	 * @return
	 */
	public static String orgSignSrc(String[] signFields, JSONObject packet) {
		if (signFields != null) {
			Arrays.sort(signFields); // 对key按照 字典顺序排序
		}

		StringBuffer signSrc = new StringBuffer("");
		int i = 0;
		for (String key : signFields) {
			signSrc.append(key);
			signSrc.append("=");
			signSrc.append((StringUtil.isBlank(packet.getString(key)) ? "" : packet.getString(key)));
			// 最后一个元素后面不加&
			if (i < (signFields.length - 1)) {
				signSrc.append("&");
			}
			i++;
		}
		return signSrc.toString();
	}
	
	/**
	 * 
	 * @Title: countSignMd5
	 * @Description: 按照支付规范计算MD5签名
	 * @param md5Key
	 * @param signFields
	 * @param json
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * 
	 * @since 1.0
	 */
	public static String countSignMd5(String md5Key, String[] signFields, JSONObject json)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String signSrc = Security.orgSignSrc(signFields, json);
		signSrc += "&KEY=" + md5Key;
		return MD5Util.getMessageDigest(signSrc);
	}
	
	public static boolean verifySignMd5(String md5Key, String[] signFields, JSONObject json) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String sign = json.getString("sign");
		String countSign = countSignMd5(md5Key, signFields, json);
		return countSign.equals(sign);
	}
}
