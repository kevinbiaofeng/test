package com.xjw.util.th;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.alibaba.fastjson.JSONObject;

/**
 * 通汇MD5加密
 */
public class THMD5Encoder {

    public static final String DEFAULT_CHARSET = "UTF-8";

    private THMD5Encoder() {}

    private static final char[] hexadecimal = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encode(String s)
    {
        return encode(s, DEFAULT_CHARSET);
    }

    public static String encode(String s, String charset) {

        if (s == null)
            return null;

        byte [] strTemp = null;
        try {
            strTemp = s.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
            return null;
        }
        MessageDigest mdTemp = null;
        try {
            mdTemp = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            return null;
        }
        mdTemp.update(strTemp);
        byte [] binaryData = mdTemp.digest();

        if (binaryData.length != 16)
            return null;

        char[] buffer = new char[32];

        for (int i=0; i<16; i++) {
            int low = binaryData[i] & 0x0f;
            int high = (binaryData[i] & 0xf0) >> 4;
            buffer[i*2] = hexadecimal[high];
            buffer[i*2 + 1] = hexadecimal[low];
        }

        return new String(buffer);
    }
    
    public static String setSign(JSONObject json){
    	StringBuilder sb = new StringBuilder();
    	sb.append("bank_code=").append(json.get("bank_code")).append("&")
    	.append("customer_ip=").append(json.get("customer_ip")).append("&")
    	.append("input_charset=").append(json.get("input_charset")).append("&")
    	.append("notify_url=").append(json.get("notify_url")).append("&")
    	.append("merchant_code=").append(json.get("merchant_code")).append("&")
    	.append("order_amount=").append(json.get("order_amount")).append("&")
    	.append("order_no=").append(json.get("order_no")).append("&")
    	.append("order_time=").append(json.get("order_time")).append("&")
    	.append("pay_type=").append(json.get("pay_type")).append("&")
    	.append("req_referer=").append(json.get("req_referer")).append("&")
    	.append("key=").append("02f775802e374fb89defe5bb83e7db79");
    	System.out.println(json);
    	System.out.println(THMD5Encoder.encode(String.valueOf(sb)));
    	return THMD5Encoder.encode(String.valueOf(sb));
    }
}
