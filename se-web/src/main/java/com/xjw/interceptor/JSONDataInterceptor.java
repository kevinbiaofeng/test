//package com.xjw.interceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.codehaus.jackson.map.DeserializationConfig;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
///**
// * 如果json数据是压缩过的，在此进行解压
// */
//@Repository
//public class JSONDataInterceptor extends HandlerInterceptorAdapter {
//
//  // @Resource(name = "systemLoggerService")
//  // private SystemLoggerService systemLoggerService;
//	
//  @Override
//  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////	  request.getHeader("gzip");
////	  MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;  
////      System.out.println(multiRequest.getFileNames());
////      Iterator<String> iter = multiRequest.getFileNames();
////      while(iter.hasNext()){
////	       MultipartFile file = multiRequest.getFile((String)iter.next());
////	       if(file != null){
////	    	   String fileName = file.getOriginalFilename();
////	    	   System.out.println(fileName);
////	       }
////      }
//	  ObjectMapper mapper = new ObjectMapper();
//	  mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//	  return true;
//  }
//  
//}
