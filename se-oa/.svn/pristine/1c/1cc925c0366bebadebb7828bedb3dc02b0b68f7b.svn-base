package com.xjw.utility;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /***
     * MD5加密 生成32位md5码
     * 
     * @param 待加密字符串
     * @return 返回32位md5码
     */
    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
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
     * 乐付 第三方 功能：MD5加密
     * 
     * @param strSrc
     *            加密的源字符串
     * @return 加密串 长度32位(hex串)
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getMessageDigest(String strSrc) {
        try {
            final String ALGO_MD5 = "MD5";
            byte[] bt = strSrc.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance(ALGO_MD5);
            md.update(bt);
            return StringUtil.byte2hex(md.digest());
        } catch (Exception e) {
            throw new RuntimeException("密码加密错误");
        }
    }

    /**
     * 乐付 第三方 将字节数组转为HEX字符串(16进制串)
     * 
     * @param bts
     *            要转换的字节数组
     * @return 转换后的HEX串
     */
    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    /**
     * 测试主函数
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        String str = new String("amigoxiexiexingxing");
        System.out.println("原始：" + str);
        System.out.println("MD5后：" + md5Encode(str));

        System.out.println(MD5Util.getMessageDigest("123123"));
    }
}
