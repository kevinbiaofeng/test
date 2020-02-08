package com.xjw.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.xjw.utility.DateUtil;

public class FileUpload {
	public static String upLoadFile(MultipartFile multipartFile, String path){
		StringBuffer filePath = new StringBuffer();
		StringBuffer returnFilePath = new StringBuffer();
		String dateDir = DateUtil.format(new Date(), "yyyyMMdd");
		String fullFileName = UUID.randomUUID() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
		InputStream is = null;
		try {
			is = multipartFile.getInputStream();
			//多文件也适用,我这里就一个文件
	//        String fileName = request.getParameter("fileName");  
	        byte[] b = new byte[(int)multipartFile.getSize()];  
	        int read = 0;  
	        int i = 0;  
	        while((read=is.read())!=-1){  
	            b[i] = (byte) read;  
	            i++;  
	        }  
	        is.close();
	        filePath.append(path).append(dateDir).append("//");
	        File file = new File(String.valueOf(filePath));
	        
	        //如果目录不存在创建目录
	        if (!file.exists() && !file.isDirectory()) {
	        	 file.mkdirs();
	        }
	        filePath.append(fullFileName);
	        OutputStream os = new FileOutputStream(new File(String.valueOf(filePath)));
	        os.write(b);  
	        os.flush();  
	        os.close();
	        return String.valueOf(returnFilePath.append(dateDir).append("//").append(fullFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
