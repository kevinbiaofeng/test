package com.xjw.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.xjw.common.exception.HttpException;

public class HttpClientUtils {
	
	private static PoolingHttpClientConnectionManager connectionManager;
	private static CloseableHttpClient httpClient;
	
	static {
		// 注册访问协议相关的socket工厂
		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)
				.register("https", SSLConnectionSocketFactory.getSystemSocketFactory())
				.build();
		
		// HttpConnection工厂: 配置写请求/解析响应处理
		HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory 
				= new ManagedHttpClientConnectionFactory(
						DefaultHttpRequestWriterFactory.INSTANCE, 
						DefaultHttpResponseParserFactory.INSTANCE);
		
		// DNS解析器
		DnsResolver dnsResolver = SystemDefaultDnsResolver.INSTANCE;
		
		// 默认为socket配置
		SocketConfig defaultSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
		
		// 创建连接池
		connectionManager = new PoolingHttpClientConnectionManager(registry, connFactory, dnsResolver);
		connectionManager.setDefaultSocketConfig(defaultSocketConfig);
		connectionManager.setMaxTotal(300);	// 设置整个连接池的最大连接数
		connectionManager.setDefaultMaxPerRoute(200); // 每个路由的最大连接数
		connectionManager.setValidateAfterInactivity(5 * 1000); // 在从连接池获取连接时，连接不活跃多长时间后需要进行一次验证
		
		//默认请求配置
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				.setConnectTimeout(2 * 1000) // 设置连接超时时间 2s
				.setSocketTimeout(5 * 1000) // 设置等待数据超时时间 5s
                .setConnectionRequestTimeout(2 * 1000)	// 设置从连接池获取连接的等待时间
                .build();
		
		httpClient = HttpClients.custom()
				.setConnectionManager(connectionManager)
				.setConnectionManagerShared(false)	// 连接池不是共享模式
				.evictIdleConnections(60, TimeUnit.SECONDS) // 定期回收空闲连接
				.evictExpiredConnections()	// 定期回收过期连接
				.setConnectionTimeToLive(60, TimeUnit.SECONDS) // 连接存活时间，如果不设置，则根据长连接信息决定
				.setDefaultRequestConfig(defaultRequestConfig) // 设置默认请求配置
				.setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE) // 连接重用策略，即是否能keepAlive
				.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)	// 长连接配置，即获取长连接生产多长时间
				.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))	// 设置重试次数，默认是3次；当前是禁用掉(根据需要开启)
				.build();
		
		// JVM停止或者重启时，关闭连接池释放连接
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * GET请求
	 * @param url	请求地址
	 */
	public static String get(String url) throws HttpException {
		HttpResponse httpResponse = null;
		
		try {
			HttpGet httpGet = new HttpGet(url);
			httpResponse = httpClient.execute(httpGet);
			if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(httpResponse.getEntity());
			} else {
			    throw new HttpException(url, httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()));
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if(null != httpResponse) {
				try {
					EntityUtils.consume(httpResponse.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
     * GET请求
     * @param url   请求地址
	 * @throws HttpException 
	 * @throws  
     */
    public static String get(String url, Map<String, String> headers) throws HttpException {
        Header[] header = headers.entrySet().stream()
                .map(x -> new BasicHeader(x.getKey(), x.getValue()))
                .toArray(Header[]::new);
        
        HttpResponse httpResponse = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeaders(header);
            
            httpResponse = httpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(httpResponse.getEntity());
            } else {
                throw new HttpException(url, httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if(null != httpResponse) {
                try {
                    EntityUtils.consume(httpResponse.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
	
	/**
	 * POST请求
	 * @param url		URL地址
	 * @param params	请求参数
	 * @return
	 */
	public static String post(String url, Map<String, String> params) throws HttpException {
		List<NameValuePair> pairList = params.entrySet().stream()
				.map(x -> new BasicNameValuePair(x.getKey(), x.getValue()))
				.collect(Collectors.toList());
		
		HttpResponse httpResponse = null;
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairList, "UTF-8");  
			
			HttpPost httpPost = new HttpPost(url);
			httpPost.setEntity(entity);
			
			httpResponse = httpClient.execute(httpPost);
			if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(httpResponse.getEntity());
			} else {
			    throw new HttpException(url, httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()));
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			if(null != httpResponse) {
				try {
					EntityUtils.consume(httpResponse.getEntity());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * post请求
	 * @param url  请求地址
	 * @param headers  请求头
	 * @param params   请求参数
	 * @return
	 */
	public static String post(String url, Map<String, String> headers, Map<String, String> params) throws HttpException {
	    Header[] header = headers.entrySet().stream()
	            .map(x -> new BasicHeader(x.getKey(), x.getValue()))
	            .toArray(Header[]::new);
	    
	    List<NameValuePair> pairList = params.entrySet().stream()
                .map(x -> new BasicNameValuePair(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
        
        HttpResponse httpResponse = null;
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairList, "UTF-8");  
            
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeaders(header);
            httpPost.setEntity(entity);
            
            httpResponse = httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(httpResponse.getEntity());
            } else {
                throw new HttpException(url, httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if(null != httpResponse) {
                try {
                    EntityUtils.consume(httpResponse.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	/**
     * post请求
     * @param url  请求地址
     * @param headers  请求头
     * @param params   请求参数
     * @return
     */
	public static String post(String url, Map<String, String> headers, String body) throws HttpException {
        Header[] header = headers.entrySet().stream()
                .map(x -> new BasicHeader(x.getKey(), x.getValue()))
                .toArray(Header[]::new);
        
        HttpResponse httpResponse = null;
        try {
            StringEntity entity = new StringEntity(body, "UTF-8");
            
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeaders(header);
            httpPost.setEntity(entity);
            
            httpResponse = httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(httpResponse.getEntity());
            } else {
                throw new HttpException(url, httpResponse.getStatusLine().getStatusCode(), EntityUtils.toString(httpResponse.getEntity()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if(null != httpResponse) {
                try {
                    EntityUtils.consume(httpResponse.getEntity());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
