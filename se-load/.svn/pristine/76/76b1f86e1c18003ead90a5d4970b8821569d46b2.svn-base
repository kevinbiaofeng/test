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
	 * 乐付  第三方
	 * 功能：MD5加密
	 * @param strSrc 加密的源字符串
	 * @return 加密串 长度32位(hex串)
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String getMessageDigest(String strSrc) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		final String ALGO_MD5 = "MD5";
		byte[] bt = strSrc.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance(ALGO_MD5);
		md.update(bt);
		String strDes = StringUtil.byte2hex(md.digest());
		return strDes;
	}

	/**
	 * 乐付  第三方
	 * 将字节数组转为HEX字符串(16进制串)
	 * @param bts 要转换的字节数组
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
//	<?xml version="1.0" encoding="utf-8"?>
//	<request action="client_loginVerf">
//	<element id="20160711203056963">
//	<properties name="pcode">J22</properties>
//	<properties name="gcode">J22300</properties>
//	<properties name="userid">kofren22</properties>
//	<properties name="password">9bc5587ad3</properties>
//	<properties name="token">d4a96cebafdb034a1d9b0dd97e3d3c4d</properties>
//	<properties name="cagent">TST_AGIN</properties>
//	<properties name="gametype">547</properties>
//	<properties name="flashid"></properties>
//	<properties name="mobile">1</properties>
//	<properties name="lang">zh</properties>
//	<properties name="session_token">67febb3dff74502653f5acd6c085d715</properties>
//	<properties name="gameCategory">0</properties><
//	properties name="custom"></properties></element></request>
	public static void main(String args[]) throws Exception {
//		String str = new String("amigoxiexiexingxing");
//		System.out.println("原始：" + str);
		//token:c9c692143eb05dd7084549eefc14252e
		System.out.println();
		DESEncrypt a  = new DESEncrypt("d3Mz7wk9");
		String pwd = a.decrypt("nxysN20uYDF1KIG0EtBYZbVCsvxHCNr0");
		pwd = "669ddfdfd071769";
		pwd = pwd.substring(4, pwd.length());
		System.out.println(pwd.substring(0, pwd.length() - 6));
		System.out.println("MD5后：" + md5Encode("J22"+"J22300"+"kofren22"+"nxysN20uYDF1KIG0EtBYZbVCsvxHCNr0"+"123123"));
//		System.out.println(MD5Util.getMessageDigest("123123"));
	}
}
