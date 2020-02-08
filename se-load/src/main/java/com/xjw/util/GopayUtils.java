package com.xjw.util;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;

import com.xjw.entity.po.pay.GuofubaoPay;
import com.xjw.kzenum.pay.GuofubaoSignType;

public class GopayUtils {
	
	
	/**
     * Convenience method to get the IP Address from client.
     * 
     * @param request the current request
     * @return IP to application
     */
    public static String getIpAddr(HttpServletRequest request) { 
    	if (request == null) return "";
    	
        String ip = request.getHeader("X-Forwarded-For"); 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_CLIENT_IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
            ip = request.getRemoteAddr(); 
        } 
        return ip; 
    } 
    
    /**
     * 对字符串进行MD5签名
     * 
     * @param text
     *            明文
     * 
     * @return 密文
     */
    public static String md5(String text) {
        return DigestUtils.md5Hex(getContentBytes(text, "UTF-8"));
    }
    
    /**
     * 对字符串进行SHA签名
     * 
     * @param text
     *            明文
     * 
     * @return 密文
     */
    public static String sha(String text) {
        return DigestUtils.shaHex(getContentBytes(text, "UTF-8"));
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException 
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }

        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }
    
    /**
     * @param type 加密的方式
     * @return
     */
    public static String setSign(GuofubaoPay guofubaoPay, String type){
    	StringBuilder sb = new StringBuilder();
    	sb.append("version=[").append(guofubaoPay.getVersion()).append("]")
    	.append("tranCode=[").append(guofubaoPay.getTranCode()).append("]")
    	.append("merchantID=[").append(guofubaoPay.getMerchantID()).append("]")
    	.append("merOrderNum=[").append(guofubaoPay.getMerOrderNum()).append("]")
    	.append("tranAmt=[").append(guofubaoPay.getTranAmt()).append("]")
    	.append("feeAmt=[").append(guofubaoPay.getFeeAmt()).append("]")
    	.append("tranDateTime=[").append(guofubaoPay.getTranDateTime()).append("]")
    	.append("frontMerUrl=[").append(guofubaoPay.getFrontMerUrl()).append("]")
    	.append("backgroundMerUrl=[").append(guofubaoPay.getBackgroundMerUrl()).append("]")
    	.append("orderId=[").append(guofubaoPay.getOrderId()).append("]")
    	.append("gopayOutOrderId=[").append(guofubaoPay.getGopayOutOrderId()).append("]")
    	.append("tranIP=[").append(guofubaoPay.getTranIP()).append("]")
    	.append("respCode=[").append(guofubaoPay.getRespCode()).append("]")
    	.append("gopayServerTime=[").append(guofubaoPay.getGopayServerTime()).append("]")
    	.append("VerficationCode=[").append(guofubaoPay.getVerficationCode()).append("]");
    	if(type.equals(GuofubaoSignType.MD5.getCode())){
    		return GopayUtils.md5(String.valueOf(sb));
    	}else if(type.equals(GuofubaoSignType.SHA.getCode()))
    		return GopayUtils.sha(String.valueOf(sb));
    	else
    		return "";
    }
    
    public static void main(String[] args) {
		
	}
}
