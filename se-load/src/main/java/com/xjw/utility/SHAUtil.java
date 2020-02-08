package com.xjw.utility;

import java.security.MessageDigest;
/** 
 * 采用SHAA加密
 */
public class SHAUtil {
	/*** 
     * SHA加密 生成40位SHA码
     * @param 待加密字符串
     * @return 返回40位SHA码
     */
    public static String shaEncode(String inStr) {
    	byte[] byteArray = null;
        MessageDigest sha = null;
        try {
        	byteArray = inStr.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

        byte[] md5Bytes = sha.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) { 
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 测试主函数
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("WC441lDR2e34lDP20151105000000010DP20151105000000010");
        System.out.println("原始：" + str);
        System.out.println("SHA后：" + shaEncode(str));
        
//        String email = "13233@qq.com";
//        
//        System.out.println(email.indexOf("@"));
//        if(email.indexOf("@") > 4){
//        	System.out.println(email.substring(0, 4) + "****" + email.substring(email.indexOf("@"), email.length()));
//        }else{
//        	System.out.println(email.substring(0, email.indexOf("@")) + "****" + email.substring(email.indexOf("@"), email.length()));
//        }
    }
}
