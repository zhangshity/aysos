package com.zcy.net.connect;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

public class SslWithCert {

    public static void main(String[] args) {
        
    }


    /**
     * 通用POST请求方法
     * @title generalPostRequest (证书信息可不传)
     * @description 证书Post通用方法
     * @author Allen.C.Y.Zhang
     * @time 2020-09-14 09:14:08
     * @param params 请求参数实体
     * @return String 响应结果
     */
    public static String generalPostRequest(GeneralRequestParametersBean params) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse httpResponse = null;
        String responseResult = null;
        try {
//			// 1.获取KeyStore,加载证书
//			KeyStore ks = KeyStore.getInstance(params.getKeyStoreType());
//			ks.load(fileInputStream = new FileInputStream(new File(params.getCertPath())), params.getCertPassword().toCharArray());
//			// 2.获取KeyManagerFactory,初始化
//			KeyManagerFactory kmf = KeyManagerFactory.getInstance(params.getKeyManagerFactoryAlgorithm());
//			kmf.init(ks,params.getCertPassword().toCharArray());
//			// 3.获取TrustManagerFactory,初始化
//			TrustManagerFactory tmf = TrustManagerFactory.getInstance(params.getTrustManagerFactoryAlgorithm());
//			tmf.init(ks, new TrustAllStrategy());
//			// 4.获取SSLContext,加载协议设置
//			SSLContext sslContext = SSLContext.getInstance(params.getSslContextProtocol() == null ? "Default" : params.getSslContextProtocol());
//			sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            // 1.初始化SSLContext (所有参数均可为空,默认TLS协议,无证书)
            SSLContextBuilder sslContextBuilder = SSLContextBuilder.create()
                    .setProtocol(params.getSslContextProtocol())
                    .setProvider(params.getProvider())
                    .setKeyStoreType(params.getKeyStoreType() != null ? params.getKeyStoreType() : KeyStore.getDefaultType())
                    .setKeyManagerFactoryAlgorithm(params.getKeyManagerFactoryAlgorithm())
                    .setTrustManagerFactoryAlgorithm(params.getTrustManagerFactoryAlgorithm())
                    .setSecureRandom(params.getSecureRandom());
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
            // 4.-3请求实体设置 (请求参数)
            StringEntity requestEntity = new StringEntity(params.getRequestParameters());
            httpRequest.setEntity(requestEntity);

            // ## 发送请求获取响应 ##
            httpResponse = httpclient.execute(httpRequest);

            // 6.获取响应实体
            HttpEntity httpEntity = httpResponse.getEntity();
            // 7.获取响应结果
            responseResult = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
            //log.info("----------------------------------------");
            //log.info("网络连接信息: {}",sslContextBuilder.toString());
            //log.info("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
            //log.info("响应结果为：{}", responseResult);
            //log.info("----------------------------------------");
        } catch (Exception e) {
            //log.error("发送请求出错", e);
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                //log.error("关闭连接错误", e);
            }
        }
        return responseResult;
    }
















//    /**
//     * 带有证书的POST请求通用方法
//     * @title generalPostRequestWithCert
//     * @description 证书Post通用方法
//     * @param params 请求参数实体
//     * @return String
//     */
//    public static String generalPostRequestWithCert(GeneralRequestParametersBean params) {
//        CloseableHttpClient httpclient = null;
//        CloseableHttpResponse httpResponse = null;
//        FileInputStream fileInputStream = null;
//        StringBuilder result = new StringBuilder();
//        try {
//            // 1.获取KeyStore,加载证书
//            KeyStore ks = KeyStore.getInstance(params.getKeyStoreType());
//            ks.load(fileInputStream = new FileInputStream(new File(params.getCertPath())), params.getCertPassword().toCharArray());
//            // 2.获取KeyManagerFactory,初始化
//            KeyManagerFactory kmf = KeyManagerFactory.getInstance(params.getKeyManagerFactoryAlgorithm());
//            kmf.init(ks,params.getCertPassword().toCharArray());
//            // 3.获取TrustManagerFactory,初始化
//            TrustManagerFactory tmf = TrustManagerFactory.getInstance(params.getTrustManagerFactoryAlgorithm());
//            tmf.init(ks);
//            // 4.获取SSLContext,加载协议设置
//            SSLContext sslContext = SSLContext.getInstance(params.getSslContextProtocol());
//            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
//            // 5.获取SocketFactory
//            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, (hostname, session) -> true);
//
//            httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
//            HttpPost httpRequest = new HttpPost(params.getRequestUrl());
//            // 请求头设置
//            if (StringUtils.isNotBlank(params.getAuthorization())) {
//                httpRequest.addHeader(HttpHeaders.AUTHORIZATION, params.getAuthorization());
//            }
//            if (StringUtils.isNotBlank(params.getAccept())) {
//                httpRequest.addHeader(HttpHeaders.ACCEPT, params.getAccept());
//            }
//            if (StringUtils.isNotBlank(params.getConnection())) {
//                httpRequest.addHeader(HttpHeaders.CONNECTION, params.getConnection());
//            }
//            if (StringUtils.isNotBlank(params.getContentType())) {
//                httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, params.getContentType());
//            }
//            if (StringUtils.isNotBlank(params.getUserAgent())) {
//                httpRequest.addHeader(HttpHeaders.USER_AGENT, params.getUserAgent());
//            }
//            if (StringUtils.isNotBlank(params.getCacheControl())) {
//                httpRequest.addHeader(HttpHeaders.CACHE_CONTROL, params.getCacheControl());
//            }
//            StringEntity requestEntity = new StringEntity(params.getRequestParameters());
//            httpRequest.setEntity(requestEntity);
//            // 设置超时时间
//            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
//                    .setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
//            httpRequest.setConfig(requestConfig);
//
//            // # 发送请求获取响应
//            httpResponse = httpclient.execute(httpRequest);
//            // 获取响应实体
//            HttpEntity httpEntity = httpResponse.getEntity();
//            //log.info("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
//            if (httpEntity != null) {
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), StandardCharsets.UTF_8));
//                String text;
//                while ((text = bufferedReader.readLine()) != null) {
//                    result.append(text);
//                }
//            }
//            EntityUtils.consume(httpEntity);
//        } catch (Exception e) {
//            //log.error("发送请求出错", e);
//        } finally {
//            try {
//                if (null != httpclient) {
//                    httpclient.close();
//                }
//                if (null != fileInputStream) {
//                    fileInputStream.close();
//                }
//                if (null != httpResponse) {
//                    httpResponse.close();
//                }
//            } catch (IOException e) {
//                //log.error("关闭连接错误", e);
//            }
//        }
//        return result.toString();
//    }


    /**
     * 通用POST请求方法
     * @title postRequestWithResponseParse
     * @description
     * @param params 请求参数实体
     * @return String 响应结果
     */
    public static String generalPostRequest1(GeneralRequestParametersBean params) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse httpResponse = null;
        String responseResult = null;
        try {
            // 1.获取SSLContext,加载协议设置
            SSLContext sslContext = SSLContext.getInstance(params.getSslContextProtocol() == null ? "Default" : params.getSslContextProtocol());
            // 2.获取SocketFactory
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, (hostname, session) -> true);
            // 3.HttpClient设置
            httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

            // 4.Http请求构建
            HttpPost httpRequest = new HttpPost(params.getRequestUrl());
            // 4.-1请求头设置
            Map<String, String> headers = params.getHeaders();
            if (!headers.isEmpty()) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    httpRequest.setHeader(header.getKey(), header.getValue());
                }
            }
            // 4.-2请求配置设置 (超时时间)
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
                    .setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
            httpRequest.setConfig(requestConfig);
            // 4.-3请求实体设置 (请求参数)
            StringEntity requestEntity = new StringEntity(params.getRequestParameters());
            httpRequest.setEntity(requestEntity);

            // ## 发送请求获取响应 ##
            httpResponse = httpclient.execute(httpRequest);
            // 5.获取响应实体
            HttpEntity httpEntity = httpResponse.getEntity();
            // 6.获取响应结果
            responseResult = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);

            //log.info("----------------------------------------");
            //log.info("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
            //log.info("响应结果为：{}", responseResult);
            //log.info("----------------------------------------");
        } catch (Exception e) {
            //log.error("发送请求出错", e);
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                //log.error("关闭连接错误", e);
            }
        }
        return responseResult;
    }


    /**
     * 带有证书的POST请求通用方法
     * @title generalPostRequestWithCert
     * @description 证书Post通用方法
     * @time 2020-09-14 09:14:08/
     * @param params 请求参数实体
     * @return String 响应结果
     */
    public static String generalPostRequestWithCert(GeneralRequestParametersBean params) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse httpResponse = null;
        FileInputStream fileInputStream = null;
        String responseResult = null;
        try {
            // 1.获取KeyStore,加载证书
            KeyStore ks = KeyStore.getInstance(params.getKeyStoreType());
            ks.load(fileInputStream = new FileInputStream(new File(params.getCertPath())), params.getCertPassword().toCharArray());
            // 2.获取KeyManagerFactory,初始化
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(params.getKeyManagerFactoryAlgorithm());
            kmf.init(ks,params.getCertPassword().toCharArray());
            // 3.获取TrustManagerFactory,初始化
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(params.getTrustManagerFactoryAlgorithm());
            tmf.init(ks);
            // 4.获取SSLContext,加载协议设置
            SSLContext sslContext = SSLContext.getInstance(params.getSslContextProtocol());
            sslContext.init(kmf.getKeyManagers(), null, null);
            // 5.获取SocketFactory
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, (hostname, session) -> true);
            // 6.HttpClient设置
            httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

            // 7.Http请求构建
            HttpPost httpRequest = new HttpPost(params.getRequestUrl());
            // 7.-1请求头设置
            Map<String, String> headers = params.getHeaders();
            if (!headers.isEmpty()) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    httpRequest.setHeader(header.getKey(), header.getValue());
                }
            }
            // 7.-2请求配置设置 (超时时间)
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
                    .setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
            httpRequest.setConfig(requestConfig);
            // 7.-3请求实体设置 (请求参数)
            StringEntity requestEntity = new StringEntity(params.getRequestParameters());
            httpRequest.setEntity(requestEntity);

            // ## 发送请求获取响应 ##
            httpResponse = httpclient.execute(httpRequest);

            // 8.获取响应实体
            HttpEntity httpEntity = httpResponse.getEntity();
            // 9.获取响应结果
            responseResult = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
            //log.info("----------------------------------------");
            //log.info("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
            //log.info("响应结果为：{}", responseResult);
            //log.info("----------------------------------------");
        } catch (Exception e) {
            //log.error("发送请求出错", e);
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                //log.error("关闭连接错误", e);
            }
        }
        return responseResult;
    }

    /**
     * 响应解析为Map的POST请求
     * @title postRequestWithResponseParse
     * @description 带有响应解析的post请求(MOLPay银行使用)
     * @author Allen.C.Y.Zhang
     * @time 2020-09-16 10:09:59
     * @param params 请求参数实体
     * @return Map<String, String> 解析为Map的响应结果
     */
    public static Map<String, String> postRequestWithResponseParse(GeneralRequestParametersBean params) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse httpResponse = null;
        BufferedReader bufferedReader = null;
        Map<String, String> responseMap = new HashMap<>(16);
        try {
            // 1.获取SSLContext,加载协议设置
            SSLContext sslContext = SSLContext.getInstance(params.getSslContextProtocol());
            // 2.获取SocketFactory
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, (hostname, session) -> true);
            // 3.HttpClient设置
            httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

            // 4.Http请求构建
            HttpPost httpRequest = new HttpPost(params.getRequestUrl());
            // 4.-1请求头设置
            Map<String, String> headers = params.getHeaders();
            if (!headers.isEmpty()) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    httpRequest.setHeader(header.getKey(), header.getValue());
                }
            }
            // 4.-2请求配置设置 (超时时间)
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
                    .setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
            httpRequest.setConfig(requestConfig);
            // 4.-3请求实体设置 (请求参数)
            StringEntity requestEntity = new StringEntity(params.getRequestParameters());
            httpRequest.setEntity(requestEntity);

            // ## 发送请求获取响应 ##
            httpResponse = httpclient.execute(httpRequest);
            // 5.获取响应实体
            HttpEntity httpEntity = httpResponse.getEntity();
            // 6.获取响应结果
            if (httpEntity != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), StandardCharsets.UTF_8));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] lineArray = line.split(":");
                    String key = lineArray[0].trim();
                    String value = lineArray[1].trim();
                    responseMap.put(key, value);
                }
            }
            EntityUtils.consume(httpEntity);
            //log.info("----------------------------------------");
            //log.info("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
            //log.info("响应结果为：{}", responseMap);
            //log.info("----------------------------------------");
        } catch (Exception e) {
            //log.error("发送请求出错", e);
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
                //log.error("关闭连接错误", e);
            }
        }
        return responseMap;
    }

}
