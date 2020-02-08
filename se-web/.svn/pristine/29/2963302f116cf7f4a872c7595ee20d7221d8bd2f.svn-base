package com.xjw.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class IpUtil {
	/**
	 * 获取到客户端IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = null;

		ip = request.getHeader("Cdn-Src-Ip");
		if (ip != null && !"".equals(ip)) {
			return ip;
		}

		ip = request.getHeader("x-forwarded-for");
		if (ip != null && ip.indexOf(',') > 0) {
			String[] tmp = ip.split("[,]");
			for (int i = 0; tmp != null && i < tmp.length; i++) {
				if (tmp[i] != null && tmp[i].length() > 0
						&& !"unknown".equalsIgnoreCase(tmp[i])) {
					ip = tmp[i];
					break;
				}
			}
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public static String getMACAddress() {
		String address = "";
		String os = System.getProperty("os.name");
		String osUser = System.getProperty("user.name");
		if (os != null && os.startsWith("Windows")) {
			try {
				String command = "cmd.exe /c ipconfig /all";
				Process p = Runtime.getRuntime().exec(command);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						p.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					if (line.indexOf("Physical Address") > 0) {
						int index = line.indexOf(":");
						index += 2;
						address = line.substring(index);
						break;
					}
				}
				br.close();
				return address.trim();
			}
			catch (IOException e) {
			}
		}
		return address;
	}
	
	public static void main(String[] args) {
		System.out.println(IpUtil.getMACAddress());
	}
}
