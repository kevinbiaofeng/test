package com.xjw.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class RequestUtils {
	/** domain正则 */
	private static final String DOMAIN_REGEX = "(?<=http://|\\.)([^.]*?\\.(gov.cn|com.cn|com|cn|net|org|biz|info|cc|tv))";
	/** IP正则 */
    private static final String IP_REGEX = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
	
    private static final Pattern DOMAIN_PATTERN = Pattern.compile(DOMAIN_REGEX, Pattern.CASE_INSENSITIVE);
    private static final Pattern IP_PATTERN = Pattern.compile(IP_REGEX);
    
    /**
     * 提取域名中的domain
     */
    public static String getDomain(HttpServletRequest request) {
    	String serverName = request.getServerName();
        
    	if (StringUtils.isNotBlank(serverName)) {
        	//如果是IP访问
        	if(IP_PATTERN.matcher(serverName).matches()){
        		return serverName;
        	}else{
	            Matcher domainMatcher = DOMAIN_PATTERN.matcher(serverName);
	            if (domainMatcher.find()){
	                return domainMatcher.group(1);
	            }
        	}
        }
        
        return null;
    }
}