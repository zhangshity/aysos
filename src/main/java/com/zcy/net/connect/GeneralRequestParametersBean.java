package com.zcy.net.connect;


import java.util.Map;

public class GeneralRequestParametersBean {

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 请求参数
     */
    private String requestParameters;

    /**
     * 超时时间
     */
    private int timeout;

    /**
     * 请求头 Request Header
     */
    private Map<String, String> headers;

//    /**
//     * Request Header - Authorization
//     */
//    private String authorization;
//
//    /**
//     * Request Header - Accept
//     */
//    private String accept;
//
//    /**
//     * Request Header - Connection
//     */
//    private String connection;
//
//    /**
//     * Request Header - Content-Type
//     */
//    private String contentType;
//
//    /**
//     * Request Header - User-Agent
//     */
//    private String userAgent;
//
//    /**
//     * Request Header - Cache-Control
//     */
//    private String cacheControl;

    /**
     * 请求协议类型(TLSv1.2 ...)
     */
    private String sslContextProtocol;

    /**
     * 证书地址
     */
    private String certPath;

    /**
     * 证书密码
     */
    private String certPassword;

    /**
     * 证书 KeyStore类型 (JKS,JCEKS,PKCS12,PKCS11)
     */
    private String keyStoreType;

    /**
     * 证书 KeyManagerFactory算法 (SunX509 ...)
     */
    private String keyManagerFactoryAlgorithm;

    /**
     * 证书 TrustManagerFactory算法
     */
    private String trustManagerFactoryAlgorithm;


    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(String requestParameters) {
        this.requestParameters = requestParameters;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getSslContextProtocol() {
        return sslContextProtocol;
    }

    public void setSslContextProtocol(String sslContextProtocol) {
        this.sslContextProtocol = sslContextProtocol;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public String getKeyStoreType() {
        return keyStoreType;
    }

    public void setKeyStoreType(String keyStoreType) {
        this.keyStoreType = keyStoreType;
    }

    public String getKeyManagerFactoryAlgorithm() {
        return keyManagerFactoryAlgorithm;
    }

    public void setKeyManagerFactoryAlgorithm(String keyManagerFactoryAlgorithm) {
        this.keyManagerFactoryAlgorithm = keyManagerFactoryAlgorithm;
    }

    public String getTrustManagerFactoryAlgorithm() {
        return trustManagerFactoryAlgorithm;
    }

    public void setTrustManagerFactoryAlgorithm(String trustManagerFactoryAlgorithm) {
        this.trustManagerFactoryAlgorithm = trustManagerFactoryAlgorithm;
    }
}
