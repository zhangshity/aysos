package com.zcy.net._simple_request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class PostTest {

    private static final Logger log = LoggerFactory.getLogger(PostTest.class);


    private static String transactionToken;

    // 我司订单号
    private static String reference = "140557897711";

    // 银行订单号
    private static String bankOrderNumber;


    public static void main(String[] args) throws JsonProcessingException {

        // ========================================= 1 拿transaction token ==================================
        System.out.println("// ========================================= 1 拿transaction token ==================================\n");
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse httpResponse = null;
        String responseResult = null;
        try {
            // 1.初始化SSLContext (所有参数均可为空,默认TLS协议,无证书)
//            SSLContextBuilder sslContextBuilder = SSLContextBuilder.create()
//                    .setProtocol(params.getSslContextProtocol())
//                    .setKeyStoreType(params.getKeyStoreType() != null ? params.getKeyStoreType() : KeyStore.getDefaultType())
//                    .setKeyManagerFactoryAlgorithm(params.getKeyManagerFactoryAlgorithm())
//                    .setTrustManagerFactoryAlgorithm(params.getTrustManagerFactoryAlgorithm())
//                    .setSecureRandom(params.getSecureRandom());
//            if (params.getProviderName() != null) {
//                sslContextBuilder = sslContextBuilder.setProvider(params.getProviderName());
//            }else {
//                sslContextBuilder = sslContextBuilder.setProvider(params.getProvider());
//            }
//            if (params.getCertPath() != null) {
//                sslContextBuilder = sslContextBuilder
//                        .loadKeyMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getKeyPassword().toCharArray(), params.getAliasStrategy())
//                        .loadTrustMaterial(new File(params.getCertPath()), params.getStorePassword().toCharArray(), params.getTrustStrategy());
//            } else {
//                sslContextBuilder = sslContextBuilder.loadTrustMaterial(params.getTrustStrategy() == null ? new TrustAllStrategy() : params.getTrustStrategy());
//            }
//            SSLContext sslContext = sslContextBuilder.build();
            SSLContext sslContext = SSLContextBuilder.create().build();
            // 2.获取SocketFactory
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext);
            // 3.HttpClient设置
            httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();

            // 4.Http请求构建
            HttpPost httpRequest = new HttpPost("https://secure-uatsb.mintpayments.net/mpay/v4/transaction_token");
            // 4.-1请求头设置
//            Map<String, String> headers = params.getHeaders();
//            if (headers != null && !headers.isEmpty()) {
//                for (Map.Entry<String, String> header : headers.entrySet()) {
//                    httpRequest.setHeader(header.getKey(), header.getValue());
//                }
//            }
            httpRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer a1b8fd86-e0ad-3955-9953-7e5a56619c47");
            httpRequest.setHeader(HttpHeaders.ACCEPT, "application/json");
            httpRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            // 4.-2请求配置设置 (超时时间)
//            if (params.getTimeout() != null) {
//                RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(params.getTimeout())
//                        .setConnectionRequestTimeout(params.getTimeout()).setSocketTimeout(params.getTimeout()).build();
//                httpRequest.setConfig(requestConfig);
//            }
            // 4.-3请求实体设置 (请求参数Json/XML/UrlEncodeForm...)
//            if (params.getRequestParameters() != null) {
//                httpRequest.setEntity(new StringEntity(params.getRequestParameters(), params.getRequestCharset()));
//            } else if (params.getRequestParametersList() != null) {
//                if (!params.getRequestParametersList().isEmpty()) {
//                    httpRequest.setEntity(new UrlEncodedFormEntity(params.getRequestParametersList(), params.getRequestCharset()));
//                }
//            }
            httpRequest.setEntity(new StringEntity("{\"company_token\": \"F3zb7fO8VH5u5F8kt81HqEMX12h659x\"}", StandardCharsets.UTF_8));


            // ## 发送请求获取响应 ##
            httpResponse = httpclient.execute(httpRequest);

            // 6.获取响应实体
            HttpEntity httpEntity = httpResponse.getEntity();
            // 7.获取响应结果
            responseResult = EntityUtils.toString(httpEntity);
            log.info("----------------------------------------");
            log.info("网络连接信息: {}", httpRequest.getRequestLine());
            log.info("响应状态信息为：{} ", httpResponse.getStatusLine().toString());
            log.info("响应结果为：{}", responseResult);
            log.info("----------------------------------------");
        } catch (Exception e) {
//            throw new RuntimeException("通用POST请求方法,请求: " + params.getRequestUrl() + "错误,请求头: " + params.getHeaders()
//                    + ",请求内容: " + Optional.ofNullable(params.getRequestParameters()).orElseGet(() -> params.getRequestParametersList().toString()), e);
            log.error("tx token请求错误: ", e);
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


        // 解析到tx token
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseResult);
        transactionToken = root.get("transaction_token").asText();
        log.info("transaction_token : {} !!!!!!!!!!!!!", transactionToken);



        // ========================================= 2 purchase ==================================
        System.out.println("// =================================================== 2 purchase =================================================================\n");
        String responseResult2 = null;
        try (CloseableHttpClient httpclient2 = HttpClients.createDefault()) {
            HttpPost httpRequest2 = new HttpPost("https://secure-uatsb.mintpayments.net/mpay/v4/purchase");
            httpRequest2.setHeader(HttpHeaders.AUTHORIZATION, "Bearer a1b8fd86-e0ad-3955-9953-7e5a56619c47");
            httpRequest2.setHeader(HttpHeaders.ACCEPT, "application/json");
            httpRequest2.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
           String entity =
                   "{\n" +
                   "    \"token\": {\n" +
                   "        \"company_token\": \"F3zb7fO8VH5u5F8kt81HqEMX12h659x\",\n" +
                   "        \"transaction_token\": \"" + transactionToken + "\"\n" +
                   "    },\n" +
                   "    \"customer\": {\n" +
                   "        \"reference\": \"" + reference + "\",\n" +
                   "        \"email\": \"allenzhang@oceanpayment.com\",\n" +
                   "        \"accepted_terms_conditions\": \"\",\n" +
                   "        \"ip_address\": \"" + InetAddress.getLocalHost().getHostAddress() + "\",\n" +
                   "        \"timezone\": \"Australia/Sydney\",\n" +
                   "        \"store_card_permission\": false,\n" +
                   "        \"id\": \"\",\n" +
                   "        \"should_mint_apply_authentication\": false,\n" +
                   "        \"authentication_redirect_url\": \"\"\n" +
                   "    },\n" +
                   "    \"card\": {\n" +
                            "\"token\": \"\",\n" +
                   "        \"number\": \"4000000360000006\",\n" +
                   "        \"expiry_month\": \"02\",\n" +
                   "        \"expiry_year\": \"24\",\n" +
                   "        \"cvc\": \"123\",\n" +
                   "        \"holder_name\": \"Allen Chunyang Zhang\"\n" +
                   "    },\n" +
                   "    \"purchase\": {\n" +
                   "        \"invoice_number\": \""+ reference+"\",\n" +
                   "        \"amount\": 100.50,\n" +
                   "        \"should_mint_apply_surcharge\": false,\n" +
                   "        \"currency\": \"AUD\"\n" +
                   "    }\n" +
                   "}";
            JsonNode purchaseRequest = objectMapper.readTree(entity);
            System.out.println(purchaseRequest.toPrettyString());


            httpRequest2.setEntity(new StringEntity(purchaseRequest.toString(), StandardCharsets.UTF_8));
            try (CloseableHttpResponse httpResponse2 = httpclient2.execute(httpRequest2)) {
                responseResult2 = EntityUtils.toString(httpResponse2.getEntity());
                log.info("----------------------------------------");
                log.info("网络连接信息: {}", httpRequest2.getRequestLine());
                log.info("网络请求内容：{}",httpRequest2.getEntity().getContent());
                log.info("响应状态信息为：{} ", httpResponse2.getStatusLine().toString());
                log.info("响应结果为：{}", responseResult2);
                log.info("----------------------------------------");
            }
        } catch (IOException e) {
            log.error("交易请求错误: ", e);
        }
        //解析

        JsonNode purchaseRoot = objectMapper.readTree(responseResult2);
        bankOrderNumber = purchaseRoot.get("purchase").get("purchase_reference").asText();




        // =========================================  3reconciliation ==================================
        System.out.println("// ===================================================  3 reconciliation =================================================================\n");

        // 对手方订单号查询
        //String reconcileApi = "https://secure-uatsb.mintpayments.net/mpay/v4/purchase/" + bankOrderNumber;
        // 我司订单号查询
        String reconcileApi = "https://secure-uatsb.mintpayments.net/mpay/v4/purchase/" + "984894654151648984";

        String responseResult3 = null;
        try (
                CloseableHttpClient httpclient3 = HttpClients.createDefault()
        ) {
            HttpPost httpRequest3 = new HttpPost(reconcileApi);
            httpRequest3.setHeader(HttpHeaders.AUTHORIZATION, "Bearer a1b8fd86-e0ad-3955-9953-7e5a56619c47");
            httpRequest3.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            httpRequest3.setEntity(new StringEntity("{\"company_token\": \"F3zb7fO8VH5u5F8kt81HqEMX12h659x\"}", StandardCharsets.UTF_8));



            try (CloseableHttpResponse httpResponse3 = httpclient3.execute(httpRequest3)) {
                responseResult3 = EntityUtils.toString(httpResponse3.getEntity());
                log.info("----------------------------------------");
                log.info("网络连接信息: {}", httpRequest3.getRequestLine());
                log.info("响应状态信息为：{} ", httpResponse3.getStatusLine());
                log.info("响应结果为：{}", responseResult3);
                log.info("----------------------------------------");
            }
        } catch (IOException e) {
            log.error("交易请求错误: ", e);
        }


        JsonNode queryRoot = objectMapper.readTree(responseResult3);
        System.out.println(queryRoot.toPrettyString());







        // =========================================  4refund ==================================
        System.out.println("// ===================================================  4 refund =================================================================\n");

        // 4.1退款新token token
        String refundToken = null;
        String newTokenResult = null;
        try (CloseableHttpClient httpclientT = HttpClients.createDefault()) {
            HttpPost httpRequest = new HttpPost("https://secure-uatsb.mintpayments.net/mpay/v4/transaction_token");
            httpRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer a1b8fd86-e0ad-3955-9953-7e5a56619c47");
            httpRequest.setHeader(HttpHeaders.ACCEPT, "application/json");
            httpRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            httpRequest.setEntity(new StringEntity("{\"company_token\": \"F3zb7fO8VH5u5F8kt81HqEMX12h659x\"}", StandardCharsets.UTF_8));
            try (CloseableHttpResponse httpResponse2 = httpclientT.execute(httpRequest)) {
                newTokenResult = EntityUtils.toString(httpResponse2.getEntity());
            }
        } catch (IOException e) {
            log.error("交易请求错误: ", e);
        }
        JsonNode newTokeNRoot = objectMapper.readTree(newTokenResult);
        refundToken = newTokeNRoot.get("transaction_token").asText();
        log.info("refundToken : {} !!!!!!!!!!!!!", refundToken);



        // 4.2拿到新token开始退款
        String refundApi = "https://secure-uatsb.mintpayments.net/mpay/v4/purchase/" + bankOrderNumber + "/refund";
        String responseResult4 = null;
        try (CloseableHttpClient httpclient4 = HttpClients.createDefault()) {
            HttpPost httpRequest4 = new HttpPost(refundApi);
            httpRequest4.setHeader(HttpHeaders.AUTHORIZATION, "Bearer a1b8fd86-e0ad-3955-9953-7e5a56619c47");
            httpRequest4.setHeader(HttpHeaders.ACCEPT, "application/json");
            httpRequest4.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            String entity = "{\n" +
                    "    \"token\": {\n" +
                    "        \"company_token\": \"F3zb7fO8VH5u5F8kt81HqEMX12h659x\",\n" +
                    "        \"transaction_token\": \"" + refundToken + "\"\n" +
                    "    },\n" +
                    "    \"customer\": {\n" +
                    "        \"customer_reference\": \"string\",\n" +
                    "        \"ip_address\": \"" + InetAddress.getLocalHost().getHostAddress() + "\",\n" +
                    "        \"timezone\": \"Australia/Sydney\"\n" +
                    "    },\n" +
                    "    \"refund\": {\n" +
                    "        \"invoice_number\": \""+ reference+1500+"\",\n" +
                    "        \"amount\": 50.25,\n" +
                    "        \"currency\": \"AUD\"\n" +
                    "    }\n" +
                    "}";
            JsonNode refundRequest = objectMapper.readTree(entity);
            System.out.println(" 退款请求参数 " +  refundRequest.toPrettyString());


            httpRequest4.setEntity(new StringEntity(refundRequest.toString(), StandardCharsets.UTF_8));
            try (CloseableHttpResponse httpResponse2 = httpclient4.execute(httpRequest4)) {
                responseResult4 = EntityUtils.toString(httpResponse2.getEntity());
                log.info("----------------------------------------");
                log.info("网络连接信息: {}", httpRequest4.getRequestLine());
                log.info("响应状态信息为：{} ", httpResponse2.getStatusLine().toString());
                log.info("响应结果为：{}", responseResult4);
                log.info("----------------------------------------");
            }
        } catch (IOException e) {
            log.error("交易请求错误: ", e);
        }
        //解析

        JsonNode refundRoot = objectMapper.readTree(responseResult4);
        System.out.println("退款结果:  " + refundRoot.toPrettyString());














    }
}
