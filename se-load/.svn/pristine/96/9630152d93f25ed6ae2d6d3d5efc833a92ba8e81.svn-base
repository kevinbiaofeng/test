package com.xjw.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
 
public class GetAddressByIp
{
    public static String GetAddressByIp01(String ip){
        String resout = ip;
        try{
	         String str = getJsonContent("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
	         JSONObject response = JSON.parseObject(str);
	         
	         Integer code = response.getInteger("code");
	         if(code == 0){
	             JSONObject data = (JSONObject) response.get("data");
	             resout =  data.get("country") +"-"+ data.get("region") + "-" +data.get("city")+"-" + data.get("isp");
	         }
        }catch(Exception e){
            resout = "获取IP地址异常：" + ip;
//            return GetAddressByIp02(ip);
        }
        return resout;
    }
    
    public static String GetAddressByIp02(String IP){
        String resout = "无效IP，局域网测试";
        try{
	         String str = getJsonContent("http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=" + IP);
	         JSONObject obj = JSON.parseObject(str);
	         Integer ret = (Integer) obj.get("ret");
	         if(ret == 1){
	        	 resout = obj.get("country") +"-"+ obj.get("province") + "-" + obj.get("city");
	         }
        }catch(Exception e){
            resout = "获取IP地址异常：" + e.getMessage();
            return resout;
        }
        return resout;
    }
    
    public static String getJsonContent(String urlStr)
    {
        try
        {// 获取HttpURLConnection连接对象
            URL url = new URL(urlStr);
            HttpURLConnection httpConn = (HttpURLConnection) url
                    .openConnection();
            // 设置连接属性
            httpConn.setConnectTimeout(3000);
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("GET");
            // 获取相应码
            int respCode = httpConn.getResponseCode();
            if (respCode == 200)
            {
                return ConvertStream2Json(httpConn.getInputStream());
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }
 
    
    private static String ConvertStream2Json(InputStream inputStream)
    {
        String jsonStr = "";
        // ByteArrayOutputStream相当于内存输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        // 将输入流转移到内存输出流中
        try
        {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1)
            {
                out.write(buffer, 0, len);
            }
            // 将内存流转换为字符串
            jsonStr = new String(out.toByteArray());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return jsonStr;
    }
    
    public static void main(String[] args) {
//    	System.out.println(GetAddressByIp("120.192.182.1"));
//    	System.out.println(GetAddressByIp01("218.192.3.42"));
    	System.out.println(GetAddressByIp02("218.192.3.42"));
	}
}