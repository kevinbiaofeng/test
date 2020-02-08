package com.xjw.common.exception;

public class HttpException extends Exception {
    private static final long serialVersionUID = -2412830643202051594L;
    
    /** 请求地址 */
    private String url;
    /** 状态码 */
    private int statusCode;
    /** 返回内容 */
    private String body;
    
    public HttpException(String url, int statusCode, String body) {
        super(statusCode + "|" + body);
        this.url = url;
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
