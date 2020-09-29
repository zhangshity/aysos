package com.zcy.net.connect;

import org.apache.http.NameValuePair;
import org.apache.http.ssl.PrivateKeyStrategy;
import org.apache.http.ssl.TrustStrategy;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

/**
 * 通用网络请求参数
 * <p>Description: 用于公共网络请求参数存放</p>
 *
 * @date 2020-09-14 11:13:00
 */

public class GeneralRequestParametersBean {

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 请求参数(类型:Json/XML)
     */
    private String requestParameters;

    /**
     * 请求参数(类型:x-www-form-urlencoded)
     */
    private List<NameValuePair> requestParametersList;

    /**
     * 超时时间
     */
    private Integer timeout;

    /**
     * 请求头 Request Header
     */
    private Map<String, String> headers;

    /**
     * 请求协议类型(SSL/TLS/TLSv1.2 ...)
     */
    private String sslContextProtocol;

    /**
     * 请求协议 Provider
     */
    private String provider;

    /**
     * 请求协议 随机数
     */
    private SecureRandom secureRandom;

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

    /**
     * 证书地址
     */
    private String certPath;

    /**
     * 证书密码(废弃)
     */
    @Deprecated
    private String certPassword;

    /**
     * KeyStore加载密码
     */
    private String storePassword;

    /**
     * KeyManagerFactory加载密码
     */
    private String keyPassword;

    /**
     * KeyManagerFactory-私钥策略
     */
    private PrivateKeyStrategy aliasStrategy;

    /**
     * TrustManagerFactory-信任策略
     */
    private TrustStrategy trustStrategy;

    /**
     * 请求内容Charset
     */
    private String requestCharset;

    /**
     * 响应内容Charset
     */
    private String responseCharset;

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

    public List<NameValuePair> getRequestParametersList() {
        return requestParametersList;
    }

    public void setRequestParametersList(List<NameValuePair> requestParametersList) {
        this.requestParametersList = requestParametersList;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public SecureRandom getSecureRandom() {
        return secureRandom;
    }

    public void setSecureRandom(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
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

    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public PrivateKeyStrategy getAliasStrategy() {
        return aliasStrategy;
    }

    public void setAliasStrategy(PrivateKeyStrategy aliasStrategy) {
        this.aliasStrategy = aliasStrategy;
    }

    public TrustStrategy getTrustStrategy() {
        return trustStrategy;
    }

    public void setTrustStrategy(TrustStrategy trustStrategy) {
        this.trustStrategy = trustStrategy;
    }

    public String getRequestCharset() {
        return requestCharset;
    }

    public void setRequestCharset(String requestCharset) {
        this.requestCharset = requestCharset;
    }

    public String getResponseCharset() {
        return responseCharset;
    }

    public void setResponseCharset(String responseCharset) {
        this.responseCharset = responseCharset;
    }
}
