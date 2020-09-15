package com.zcy.net.connect;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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

public class SslWithCert {

    public static void main(String[] args) {
        
    }


    /**
     * 带有证书的POST请求通用方法
     * @title generalPostRequestWithCert
     * @description 证书Post通用方法
     * @param params 请求参数实体
     * @return String
     */
    public static String generalPostRequestWithCert(GeneralRequestParametersBean params) {
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse httpResponse = null;
        FileInputStream fileInputStream = null;
        StringBuilder result = new StringBuilder();
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
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
            // 5.获取SocketFactory
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, (hostname, session) -> true);

            httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
            HttpPost httpRequest = new HttpPost(params.getRequestUrl());
            // 请求头设置
            if (StringUtils.isNotBlank(params.getAuthorization())) {
                httpRequest.addHeader(HttpHeaders.AUTHORIZATION, params.getAuthorization());
            }
            if (StringUtils.isNotBlank(params.getAccept())) {
                httpRequest.addHeader(HttpHeaders.ACCEPT, params.getAccept());
            }
            if (StringUtils.isNotBlank(params.getConnection())) {
                httpRequest.addHeader(HttpHeaders.CONNECTION, params.getConnection());
            }
            if (StringUtils.isNotBlank(params.getContentType())) {
                httpRequest.addHeader(HttpHeaders.CONTENT_TYPE, params.getContentType());
            }
            if (StringUtils.isNotBlank(params.getUserAgent())) {
                httpRequest.addHeader(HttpHeaders.USER_AGENT, params.getUserAgent());
            }
            if (StringUtils.isNotBlank(params.getCacheControl())) {
                httpRequest.addHeader(HttpHeaders.CACHE_CONTROL, params.getCacheControl());
            }
            StringEntity requestEntity = new StringEntity(params.getRequestParameters());
            httpRequest.setEntity(requestEntity);
            // 设置超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
                    .setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
            httpRequest.setConfig(requestConfig);

            // # 发送请求获取响应
            httpResponse = httpclient.execute(httpRequest);
            // 获取响应实体
            HttpEntity httpEntity = httpResponse.getEntity();
            //log.info("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
            if (httpEntity != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), StandardCharsets.UTF_8));
                String text;
                while ((text = bufferedReader.readLine()) != null) {
                    result.append(text);
                }
            }
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            //log.error("发送请求出错", e);
        } finally {
            try {
                if (null != httpclient) {
                    httpclient.close();
                }
                if (null != fileInputStream) {
                    fileInputStream.close();
                }
                if (null != httpResponse) {
                    httpResponse.close();
                }
            } catch (IOException e) {
                //log.error("关闭连接错误", e);
            }
        }
        return result.toString();
    }

}
