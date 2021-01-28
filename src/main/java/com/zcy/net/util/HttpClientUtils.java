package com.zcy.net.util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <p>Title: HTTP客户端网络请求工具类</p>
 * <p>Description: 通用方法使用：请求参数放入<code>GeneralRequestParametersBean</code>参数实体类中</p>
 * @author Your Daddy
 * @version V2.0
 * @date 2020年3月24日 下午8:18:49
 */
public class HttpClientUtils {

	private static final Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

	/**
	 * 微服务通讯授权码(内部系统)
	 */
	private static final String MICRO_SERVICE_AUTHORIZATION_CODE = "service-user:fuckyoua-1234-5678-6543-qunimade438a";

	/**
	 * 微服务请求超时时间
	 */
	private final static int CONNECTION_TIMEOUT = 45000;


	/**
	 * 通用微服务请求方法
	 * #可能抛出<code>RuntimeException</code>,调用此方法请try-catch处理可能的异常.日志级别默认debug,请在业务方法自行打印
	 * @author Allen.C.Y.Zhang
	 * @date  2020-12-24 15:28:46
	 * @param requestUrl     微服务系统URL
	 * @param requestContent 请求内容
	 * @return String        响应内容
	 */
	public static String generalMicroserviceRequest(String requestUrl, String requestContent) {
		CloseableHttpClient httpclient = null;
		HttpPost httpRequest = null;
		CloseableHttpResponse httpResponse = null;
		String responseResult = null;
		try {
			// 1.初始化SSLContext (系统默认)
			// 2.获取SocketFactory
			SSLConnectionSocketFactory sslSocketFactory = SSLConnectionSocketFactory.getSystemSocketFactory();
			// 3.HttpClient设置
			httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

			// 4.Http请求构建
			httpRequest = new HttpPost(requestUrl);
			// 4.-1请求头设置
			String auth = Base64.getEncoder().encodeToString(MICRO_SERVICE_AUTHORIZATION_CODE.getBytes());
			httpRequest.setHeader("Authorization", "Basic " + auth);
			httpRequest.setHeader("Content-Type", "application/json");
			// 4.-2请求配置设置 (超时时间)
			RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(CONNECTION_TIMEOUT)
					.setSocketTimeout(CONNECTION_TIMEOUT).setConnectTimeout(CONNECTION_TIMEOUT).build();
			httpRequest.setConfig(requestConfig);
			// 4.-3请求实体设置
			httpRequest.setEntity(new StringEntity(requestContent, StandardCharsets.UTF_8));

			// ## 发送请求获取响应 ##
			httpResponse = httpclient.execute(httpRequest);

			// 6.获取响应实体
			HttpEntity httpEntity = httpResponse.getEntity();
			// 7.获取响应结果
			responseResult = EntityUtils.toString(httpEntity);
			log.debug("----------------------------------------");
			log.debug("网络连接信息: {}", httpRequest.getRequestLine());
			log.debug("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
			log.debug("响应结果为：{}", responseResult);
			log.debug("----------------------------------------");
		} catch (Exception e) {
			throw new RuntimeException("通用微服务请求方法,请求: " + requestUrl + "错误,响应状态: "
					+ Optional.ofNullable(httpResponse).map(HttpResponse::getStatusLine).map(Object::toString).orElse("")
					+ "\n    - 请求头: " + Optional.ofNullable(httpRequest).map(HttpRequest::getAllHeaders).map(x -> Arrays.asList(x).toString()).orElse(null)
					+ "\n    - 请求内容: " + requestContent, e);
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error("通用微服务请求方法,关闭连接错误", e);
			}
		}
		return responseResult;
	}

	/**
	 * 通用GET请求方法
	 * #可能抛出<code>RuntimeException</code>,调用此方法请try-catch处理可能的异常.日志级别默认debug,请在业务方法自行打印
	 * @param params 请求参数实体
	 * @return String 响应结果
	 */
	public static String generalGetRequest(GeneralRequestParametersBean params) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse httpResponse = null;
		String responseResult = null;
		try {
			// 1.初始化SSLContext (所有参数均可为空,默认TLS协议,无证书)
			SSLContextBuilder sslContextBuilder = SSLContextBuilder.create()
					.setProtocol(params.getSslContextProtocol())
					.setKeyStoreType(params.getKeyStoreType() != null ? params.getKeyStoreType() : KeyStore.getDefaultType())
					.setKeyManagerFactoryAlgorithm(params.getKeyManagerFactoryAlgorithm())
					.setTrustManagerFactoryAlgorithm(params.getTrustManagerFactoryAlgorithm())
					.setSecureRandom(params.getSecureRandom());
			if (params.getProviderName() != null) {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProviderName());
			}else {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProvider());
			}
			if (params.getCertPath() != null) {
				sslContextBuilder = sslContextBuilder
						.loadKeyMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getKeyPassword().toCharArray(), params.getAliasStrategy())
						.loadTrustMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getTrustStrategy());
			} else {
				sslContextBuilder = sslContextBuilder.loadTrustMaterial(params.getTrustStrategy() == null ? new TrustAllStrategy() : params.getTrustStrategy());
			}
			SSLContext sslContext = sslContextBuilder.build();

			// 2.获取SocketFactory
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
			// 3.HttpClient设置
			httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

			// 4.Http请求构建
			HttpGet httpRequest = new HttpGet(params.getRequestUrl());
			// 4.-1请求头设置
			Map<String, String> headers = params.getHeaders();
			if (!headers.isEmpty()) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpRequest.setHeader(header.getKey(), header.getValue());
				}
			}
			// 4.-2请求配置设置 (超时时间)
			if (params.getTimeout() != null) {
				RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
						.setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
				httpRequest.setConfig(requestConfig);
			}

			// ## 发送请求获取响应 ##
			httpResponse = httpclient.execute(httpRequest);

			// 5.获取响应实体
			HttpEntity httpEntity = httpResponse.getEntity();
			// 6.获取响应结果
			responseResult = EntityUtils.toString(httpEntity, params.getResponseCharset() != null ? Charset.forName(params.getResponseCharset()) : ContentType.get(httpEntity).getCharset());
			log.debug("----------------------------------------");
			log.debug("网络连接信息: {}", httpRequest.getRequestLine());
			log.debug("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
			log.debug("响应结果为：{}", responseResult);
			log.debug("----------------------------------------");
		} catch (Exception e) {
			throw new RuntimeException("通用GET请求方法,请求: " + params.getRequestUrl() + "错误,响应状态: "
					+ Optional.ofNullable(httpResponse).map(HttpResponse::getStatusLine).map(Object::toString).orElse("")
					+ "\n    - 请求头: " + params.getHeaders(), e);
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error("通用GET请求方法,关闭连接错误", e);
			}
		}
		return responseResult;
	}

	/**
	 * 通用PUT请求方法
	 * #可能抛出<code>RuntimeException</code>,调用此方法请try-catch处理可能的异常.日志级别默认debug,请在业务方法自行打印
	 * @param params 请求参数实体
	 * @return String 响应结果
	 */
	public static String generalPutRequest(GeneralRequestParametersBean params) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse httpResponse = null;
		String responseResult = null;
		try {
			// 1.初始化SSLContext (所有参数均可为空,默认TLS协议,无证书)
			SSLContextBuilder sslContextBuilder = SSLContextBuilder.create()
					.setProtocol(params.getSslContextProtocol())
					.setKeyStoreType(params.getKeyStoreType() != null ? params.getKeyStoreType() : KeyStore.getDefaultType())
					.setKeyManagerFactoryAlgorithm(params.getKeyManagerFactoryAlgorithm())
					.setTrustManagerFactoryAlgorithm(params.getTrustManagerFactoryAlgorithm())
					.setSecureRandom(params.getSecureRandom());
			if (params.getProviderName() != null) {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProviderName());
			}else {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProvider());
			}
			if (params.getCertPath() != null) {
				sslContextBuilder = sslContextBuilder
						.loadKeyMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getKeyPassword().toCharArray(), params.getAliasStrategy())
						.loadTrustMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getTrustStrategy());
			} else {
				sslContextBuilder = sslContextBuilder.loadTrustMaterial(params.getTrustStrategy() == null ? new TrustAllStrategy() : params.getTrustStrategy());
			}
			SSLContext sslContext = sslContextBuilder.build();

			// 2.获取SocketFactory
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
			// 3.HttpClient设置
			httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

			// 4.Http请求构建
			HttpPut httpRequest = new HttpPut(params.getRequestUrl());
			// 4.-1请求头设置
			Map<String, String> headers = params.getHeaders();
			if (!headers.isEmpty()) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpRequest.setHeader(header.getKey(), header.getValue());
				}
			}
			// 4.-2请求配置设置 (超时时间)
			if (params.getTimeout() != null) {
				RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
						.setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
				httpRequest.setConfig(requestConfig);
			}
			// 4.-3请求实体设置 (请求参数Json/XML/UrlEncodeForm...)
			if (params.getRequestParameters() != null) {
				httpRequest.setEntity(new StringEntity(params.getRequestParameters(), params.getRequestCharset()));
			} else if (params.getRequestParametersList() != null) {
				if (!params.getRequestParametersList().isEmpty()) {
					httpRequest.setEntity(new UrlEncodedFormEntity(params.getRequestParametersList(), params.getRequestCharset()));
				}
			}

			// ## 发送请求获取响应 ##
			httpResponse = httpclient.execute(httpRequest);

			// 5.获取响应实体
			HttpEntity httpEntity = httpResponse.getEntity();
			// 6.获取响应结果
			responseResult = EntityUtils.toString(httpEntity, params.getResponseCharset() != null ? Charset.forName(params.getResponseCharset()) : ContentType.get(httpEntity).getCharset());
			log.debug("----------------------------------------");
			log.debug("网络连接信息: {}", httpRequest.getRequestLine());
			log.debug("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
			log.debug("响应结果为：{}", responseResult);
			log.debug("----------------------------------------");
		} catch (Exception e) {
			throw new RuntimeException("通用PUT请求方法,请求: " + params.getRequestUrl() + "错误响应状态: "
					+ Optional.ofNullable(httpResponse).map(HttpResponse::getStatusLine).map(Object::toString).orElse("")
					+ "\n    - 请求头: " + params.getHeaders()
					+ "\n    - 请求内容: " + Optional.ofNullable(params.getRequestParameters()).orElseGet(() -> params.getRequestParametersList().toString()), e);
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error("通用PUT请求方法,关闭连接错误", e);
			}
		}
		return responseResult;
	}

	/**
	 * 通用POST请求方法
	 * #可能抛出<code>RuntimeException</code>,调用此方法请try-catch处理可能的异常.日志级别默认debug,请在业务方法自行打印
	 * @param params 请求参数实体
	 * @return String 响应结果
	 */
	public static String generalPostRequest(GeneralRequestParametersBean params) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse httpResponse = null;
		String responseResult = null;
		try {
			// 1.初始化SSLContext (所有参数均可为空,默认TLS协议,无证书)
			SSLContextBuilder sslContextBuilder = SSLContextBuilder.create()
					.setProtocol(params.getSslContextProtocol())
					.setKeyStoreType(params.getKeyStoreType() != null ? params.getKeyStoreType() : KeyStore.getDefaultType())
					.setKeyManagerFactoryAlgorithm(params.getKeyManagerFactoryAlgorithm())
					.setTrustManagerFactoryAlgorithm(params.getTrustManagerFactoryAlgorithm())
					.setSecureRandom(params.getSecureRandom());
			if (params.getProviderName() != null) {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProviderName());
			}else {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProvider());
			}
			if (params.getCertPath() != null) {
				sslContextBuilder = sslContextBuilder
						.loadKeyMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getKeyPassword().toCharArray(), params.getAliasStrategy())
						.loadTrustMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getTrustStrategy());
			} else {
				sslContextBuilder = sslContextBuilder.loadTrustMaterial(params.getTrustStrategy() == null ? new TrustAllStrategy() : params.getTrustStrategy());
			}
			SSLContext sslContext = sslContextBuilder.build();
			// 2.获取SocketFactory
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
			// 3.HttpClient设置
			httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

			// 4.Http请求构建
			HttpPost httpRequest = new HttpPost(params.getRequestUrl());
			// 4.-1请求头设置
			Map<String, String> headers = params.getHeaders();
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpRequest.setHeader(header.getKey(), header.getValue());
				}
			}
			// 4.-2请求配置设置 (超时时间)
			if (params.getTimeout() != null) {
				RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
						.setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
				httpRequest.setConfig(requestConfig);
			}
			// 4.-3请求实体设置 (请求参数Json/XML/UrlEncodeForm...)
			if (params.getRequestParameters() != null) {
				httpRequest.setEntity(new StringEntity(params.getRequestParameters(), params.getRequestCharset()));
			} else if (params.getRequestParametersList() != null) {
				if (!params.getRequestParametersList().isEmpty()) {
					httpRequest.setEntity(new UrlEncodedFormEntity(params.getRequestParametersList(), params.getRequestCharset()));
				}
			}

			// ## 发送请求获取响应 ##
			httpResponse = httpclient.execute(httpRequest);

			// 6.获取响应实体
			HttpEntity httpEntity = httpResponse.getEntity();
			// 7.获取响应结果
			responseResult = EntityUtils.toString(httpEntity, params.getResponseCharset() != null ? Charset.forName(params.getResponseCharset()) : ContentType.get(httpEntity).getCharset());
			log.debug("----------------------------------------");
			log.debug("网络连接信息: {}", httpRequest.getRequestLine());
			log.debug("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
			log.debug("响应结果为：{}", responseResult);
			log.debug("----------------------------------------");
		} catch (Exception e) {
			throw new RuntimeException("通用POST请求方法,请求: " + params.getRequestUrl() + "错误,响应状态: "
					+ Optional.ofNullable(httpResponse).map(HttpResponse::getStatusLine).map(Object::toString).orElse("")
					+ "\n    - 请求头: " + params.getHeaders()
					+ "\n    - 请求内容: " + Optional.ofNullable(params.getRequestParameters()).orElseGet(() -> params.getRequestParametersList().toString()), e);
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error("通用POST请求方法,关闭连接错误", e);
			}
		}
		return responseResult;
	}

	/**
	 * 响应解析为Map的GET请求
	 * 带有响应解析的post请求 #可能抛出<code>RuntimeException</code>,调用此方法请try-catch处理可能的异常.日志级别默认debug,请在业务方法自行打印
	 * @param params 请求参数实体
	 * @return Map<String, String> 解析为Map的响应结果
	 */
	public static Map<String, String> generalGetRequestWithResponseParse(GeneralRequestParametersBean params) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse httpResponse = null;
		BufferedReader bufferedReader = null;
		Map<String, String> responseMap = new HashMap<>(16);
		try {
			// 1.初始化SSLContext (所有参数均可为空,默认TLS协议,无证书)
			SSLContextBuilder sslContextBuilder = SSLContextBuilder.create()
					.setProtocol(params.getSslContextProtocol())
					.setKeyStoreType(params.getKeyStoreType() != null ? params.getKeyStoreType() : KeyStore.getDefaultType())
					.setKeyManagerFactoryAlgorithm(params.getKeyManagerFactoryAlgorithm())
					.setTrustManagerFactoryAlgorithm(params.getTrustManagerFactoryAlgorithm())
					.setSecureRandom(params.getSecureRandom());
			if (params.getProviderName() != null) {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProviderName());
			}else {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProvider());
			}
			if (params.getCertPath() != null) {
				sslContextBuilder = sslContextBuilder
						.loadKeyMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getKeyPassword().toCharArray(), params.getAliasStrategy())
						.loadTrustMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getTrustStrategy());
			} else {
				sslContextBuilder = sslContextBuilder.loadTrustMaterial(params.getTrustStrategy() == null ? new TrustAllStrategy() : params.getTrustStrategy());
			}
			SSLContext sslContext = sslContextBuilder.build();
			// 2.获取SocketFactory
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
			// 3.HttpClient设置
			httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

			// 4.Http请求构建
			HttpGet httpRequest = new HttpGet(params.getRequestUrl());
			// 4.-1请求头设置
			Map<String, String> headers = params.getHeaders();
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpRequest.setHeader(header.getKey(), header.getValue());
				}
			}
			// 4.-2请求配置设置 (超时时间)
			if (params.getTimeout() != null) {
				RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
						.setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
				httpRequest.setConfig(requestConfig);
			}

			// ## 发送请求获取响应 ##
			httpResponse = httpclient.execute(httpRequest);
			// 6.获取响应实体
			HttpEntity httpEntity = httpResponse.getEntity();
			// 7.获取响应结果
			if (httpEntity != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), params.getResponseCharset() != null ? Charset.forName(params.getResponseCharset()) : ContentType.get(httpEntity).getCharset()));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					log.debug("获取银行响应逐行读取:{}", line);
					String lineDecoded = URLDecoder.decode(line, StandardCharsets.UTF_8.name());
					String[] lineArray = lineDecoded.split(":");
					// 判断有无：分隔符(防止特殊情况数组下表越界)
					if (lineArray.length == 2) {
						String key = lineArray[0].trim();
						String value = lineArray[1].trim();
						responseMap.put(key, value);
					} else {
						responseMap.put(Arrays.toString(lineArray), null);
					}
				}
			}
			EntityUtils.consume(httpEntity);
			log.debug("----------------------------------------");
			log.debug("网络连接信息: {}", httpRequest.getRequestLine());
			log.debug("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
			log.debug("响应结果为：{}", responseMap);
			log.debug("----------------------------------------");
		} catch (Exception e) {
			throw new RuntimeException("通用带Map解析GET请求方法,请求: " + params.getRequestUrl() + "错误,响应状态: "
					+ Optional.ofNullable(httpResponse).map(HttpResponse::getStatusLine).map(Object::toString).orElse("")
					+ "\n    - 请求头: " + params.getHeaders(), e);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (httpResponse != null) {
					httpResponse.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error("通用带Map解析GET请求方法,关闭连接错误", e);
			}
		}
		return responseMap;
	}

	/**
	 * 响应解析为Map的POST请求
	 * 带有响应解析的post请求 #可能抛出<code>RuntimeException</code>,调用此方法请try-catch处理可能的异常.日志级别默认debug,请在业务方法自行打印
	 * @param params 请求参数实体
	 * @return Map<String, String> 解析为Map的响应结果
	 */
	public static Map<String, String> generalPostRequestWithResponseParse(GeneralRequestParametersBean params) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse httpResponse = null;
		BufferedReader bufferedReader = null;
		Map<String, String> responseMap = new HashMap<>(16);
		try {
			// 1.初始化SSLContext (所有参数均可为空,默认TLS协议,无证书)
			SSLContextBuilder sslContextBuilder = SSLContextBuilder.create()
					.setProtocol(params.getSslContextProtocol())
					.setKeyStoreType(params.getKeyStoreType() != null ? params.getKeyStoreType() : KeyStore.getDefaultType())
					.setKeyManagerFactoryAlgorithm(params.getKeyManagerFactoryAlgorithm())
					.setTrustManagerFactoryAlgorithm(params.getTrustManagerFactoryAlgorithm())
					.setSecureRandom(params.getSecureRandom());
			if (params.getProviderName() != null) {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProviderName());
			}else {
				sslContextBuilder = sslContextBuilder.setProvider(params.getProvider());
			}
			if (params.getCertPath() != null) {
				sslContextBuilder = sslContextBuilder
						.loadKeyMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getKeyPassword().toCharArray(), params.getAliasStrategy())
						.loadTrustMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getTrustStrategy());
			} else {
				sslContextBuilder = sslContextBuilder.loadTrustMaterial(params.getTrustStrategy() == null ? new TrustAllStrategy() : params.getTrustStrategy());
			}
			SSLContext sslContext = sslContextBuilder.build();
			// 2.获取SocketFactory
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
			// 3.HttpClient设置
			httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

			// 4.Http请求构建
			HttpPost httpRequest = new HttpPost(params.getRequestUrl());
			// 4.-1请求头设置
			Map<String, String> headers = params.getHeaders();
			if (headers != null && !headers.isEmpty()) {
				for (Map.Entry<String, String> header : headers.entrySet()) {
					httpRequest.setHeader(header.getKey(), header.getValue());
				}
			}
			// 4.-2请求配置设置 (超时时间)
			if (params.getTimeout() != null) {
				RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
						.setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
				httpRequest.setConfig(requestConfig);
			}
			// 4.-3请求实体设置 (请求参数Json/XML/UrlEncodeForm...)
			if (params.getRequestParameters() != null) {
				httpRequest.setEntity(new StringEntity(params.getRequestParameters(), params.getRequestCharset()));
			} else if (params.getRequestParametersList() != null) {
				if (!params.getRequestParametersList().isEmpty()) {
					httpRequest.setEntity(new UrlEncodedFormEntity(params.getRequestParametersList(), params.getRequestCharset()));
				}
			}

			// ## 发送请求获取响应 ##
			httpResponse = httpclient.execute(httpRequest);
			// 6.获取响应实体
			HttpEntity httpEntity = httpResponse.getEntity();
			// 7.获取响应结果
			if (httpEntity != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), params.getResponseCharset() != null ? Charset.forName(params.getResponseCharset()) : ContentType.get(httpEntity).getCharset()));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					log.debug("获取银行响应逐行读取:{}", line);
					String lineDecoded = URLDecoder.decode(line, StandardCharsets.UTF_8.name());
					String[] lineArray = lineDecoded.split(":");
					// 判断有无：分隔符(防止特殊情况数组下表越界)
					if (lineArray.length == 2) {
						String key = lineArray[0].trim();
						String value = lineArray[1].trim();
						responseMap.put(key, value);
					} else {
						responseMap.put(Arrays.toString(lineArray), null);
					}
				}
			}
			EntityUtils.consume(httpEntity);
			log.debug("----------------------------------------");
			log.debug("网络连接信息: {}", httpRequest.getRequestLine());
			log.debug("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
			log.debug("响应结果为：{}", responseMap);
			log.debug("----------------------------------------");
		} catch (Exception e) {
			throw new RuntimeException("通用带Map解析POST请求方法,请求: " + params.getRequestUrl() + "错误,响应状态: "
					+ Optional.ofNullable(httpResponse).map(HttpResponse::getStatusLine).map(Object::toString).orElse("")
					+ "\n    - 请求头: " + params.getHeaders()
					+ "\n    - 请求内容: " + Optional.ofNullable(params.getRequestParameters()).orElseGet(() -> params.getRequestParametersList().toString()), e);
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (httpResponse != null) {
					httpResponse.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				log.error("通用带Map解析POST请求方法,关闭连接错误", e);
			}
		}
		return responseMap;
	}
}