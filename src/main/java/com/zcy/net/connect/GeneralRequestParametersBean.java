package com.zcy.net.connect;


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
     * Request Header - Authorization
     */
    private String authorization;

    /**
     * Request Header - Accept
     */
    private String accept;

    /**
     * Request Header - Connection
     */
    private String connection;

    /**
     * Request Header - Content-Type
     */
    private String contentType;

    /**
     * Request Header - User-Agent
     */
    private String userAgent;

    /**
     * Request Header - Cache-Control
     */
    private String cacheControl;

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

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
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
