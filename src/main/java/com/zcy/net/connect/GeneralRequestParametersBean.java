package com.oceanpayment.common.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;

/**
 * 通用网络请求参数
 * <p>Title: GeneralRequestParametersBean</p>
 * <p>Description: 用于公共网络请求参数存放</p>
 * <p>Copyright: Copyright (c) 2020 版权</p>
 * <p>Company: Oceanpayment</p
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2020-09-14 11:13:00
 */
@Getter
@Setter
@ToString
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
}
