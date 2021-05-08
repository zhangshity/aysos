package com.zcy.net._urlconnection_httpclient_cmp;

import com.zcy.net.util.GeneralRequestParametersBean;
import com.zcy.net.util.HttpClientUtils;
import org.apache.http.conn.ssl.TrustAllStrategy;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class Test {




    public static void main(String[] args) {
        String postUrl = "https://apihk.mch.weixin.qq.com/pay/orderquery";

        String parameter = "<xml><appid>wx0dd3d8d451dd4907</appid><mch_id>1499429942</mch_id><nonce_str>1620383220252</nonce_str><sign>AA507DB768E8A9620AE2218CC8C1E675</sign><out_trade_no>210506182936919185032</out_trade_no><sub_mch_id>200393666</sub_mch_id></xml>";

        // 3.连接信息配置
        GeneralRequestParametersBean connectionParams = new GeneralRequestParametersBean();
        connectionParams.setRequestUrl(postUrl);
        connectionParams.setSslContextProtocol("TLSv1.2");
        connectionParams.setTimeout(35000);
        connectionParams.setTrustStrategy(new TrustAllStrategy());
        connectionParams.setSecureRandom(new SecureRandom());

//        Map<String, String> headers = new HashMap<>(16);
//        headers.put(HttpHeaders.CONNECTION, HttpConstants.REQUEST_PROPERTY_CONNECTION);
//        headers.put(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE);
//            headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE);
//        headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE + "; charset=UTF-8");
//        headers.put(HttpHeaders.HOST, "api.mch.weixin.qq.com");
//        headers.put("X-Requested-With", "XMLHttpRequest");
//        headers.put(HttpHeaders.CACHE_CONTROL, "max-age=0");
//        headers.put(HttpHeaders.USER_AGENT, "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
//        connectionParams.setHeaders(headers);
        connectionParams.setRequestParameters(parameter);
        connectionParams.setResponseCharset(StandardCharsets.UTF_8.name());




        String bankResponse = HttpClientUtils.generalPostRequest(connectionParams);
        System.out.println(bankResponse);
        System.out.println("=================================================================");





        StringBuilder result = new StringBuilder();
        HttpsURLConnection connection = null;
        java.io.DataOutputStream out = null;
        BufferedReader in = null;
        try {
            // 设置连接协议
            SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            // 打开和URL之间的连接
            URL url = new URL(null, postUrl, new sun.net.www.protocol.https.Handler());
            connection = (HttpsURLConnection) url.openConnection();
//            connection.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            connection.setSSLSocketFactory(sc.getSocketFactory());
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
//            connection.setUseCaches(false);
//            connection.setInstanceFollowRedirects(false);
//            connection.setRequestProperty("Connection", "keep-alive");
//            connection.setRequestProperty("Accept", "*/*");
//            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
//            connection.setRequestProperty("Host", "api.mch.weixin.qq.com");
//            connection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
//            connection.setRequestProperty("Cache-Control", "max-age=0");
//            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
//            connection.setConnectTimeout(35000);
//            connection.setReadTimeout(35000);
            connection.connect();
            out = new java.io.DataOutputStream(connection.getOutputStream());
            out.writeBytes(parameter);
//            out.flush();
//            out.writeUTF(parameter); //<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[XML格式错误]]></return_msg></xml>



            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
//            logger.error("请求出现异常！", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (IOException ex) {
//                logger.info("!!!!", ex);
            }
        }
        System.out.println(result);







    }
    static TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
        }
    }
    };
}
