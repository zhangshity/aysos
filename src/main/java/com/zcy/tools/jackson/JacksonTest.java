package com.zcy.tools.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ Author: chunyang.zhang
 * @ Description: jackson解析json
 * @ Date: Created in 21:49 2020-09-02
 * @ Modified: By:
 */
public class JacksonTest {

    public static void main(String[] args) throws JsonProcessingException {


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(FUCKING_JSON_STRING);


        String amount = jsonNode.get("amount").asText();
        String currency = jsonNode.get("currency").asText();
        String code = jsonNode.get("result").asText();

        System.out.println(amount);
        System.out.println(currency);
        System.out.println(code);


        JsonNode transactionArrayStr = jsonNode.get("transaction");
        if (transactionArrayStr.isArray()) {
            System.out.println("transaction is array? " + transactionArrayStr.isArray());

            for (JsonNode subNode : transactionArrayStr) {
                System.out.println(subNode);
                JsonNode finalNode = subNode.get("transaction");
                System.out.println(finalNode);
            }


        }
        //System.out.println(trans);

        System.out.println("==================================简单json报文======================================");
        JsonNode node = objectMapper.readTree(SIMPLE_JSON);
        JsonNode j1 = node.get("result");
        JsonNode j2 = node.get("sourceOfFunds");
        JsonNode j3 = j2.get("type");
        JsonNode j4 = node.get("sourceOfFunds").get("provided").get("card");   //每一层都是一个JsonNode对象,可以一层一层的取
        System.out.println(j1);
        System.out.println(j2);
        System.out.println(j3);
        System.out.println(j4);


        System.out.println("========================== 空值测试(优秀组件处理了空指针异常) ==============================");
        String j5 = node.get("www").textValue();
        String j6 = node.has("result") ? node.get("result").asText() : null;
        //System.out.println(j5);
        System.out.println(j6);
    }


    private static String FUCKING_JSON_STRING = "{\n" +
            "    \"amount\": 0.01,\n" +
            "    \"chargeback\": {\n" +
            "        \"amount\": 0,\n" +
            "        \"currency\": \"USD\"\n" +
            "    },\n" +
            "    \"creationTime\": \"2020-09-02T10:45:40.432Z\",\n" +
            "    \"currency\": \"USD\",\n" +
            "    \"customerOrderDate\": \"2020-09-02\",\n" +
            "    \"device\": {\n" +
            "        \"browser\": \"mozilla/5.0 (windows nt 6.1; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/85.0.4183.83 safari/537.36\",\n" +
            "        \"ipAddress\": \"119.139.197.88\"\n" +
            "    },\n" +
            "    \"id\": \"200902184409258010255\",\n" +
            "    \"merchant\": \"020500073170\",\n" +
            "    \"merchantCategoryCode\": \"5999\",\n" +
            "    \"reference\": \"200902184409258010255\",\n" +
            "    \"result\": \"SUCCESS\",\n" +
            "    \"sourceOfFunds\": {\n" +
            "        \"provided\": {\n" +
            "            \"card\": {\n" +
            "                \"brand\": \"VISA\",\n" +
            "                \"expiry\": {\n" +
            "                    \"month\": \"6\",\n" +
            "                    \"year\": \"21\"\n" +
            "                },\n" +
            "                \"fundingMethod\": \"CREDIT\",\n" +
            "                \"issuer\": \"CHINA MERCHANTS BANK\",\n" +
            "                \"number\": \"439226xxxxxx5920\",\n" +
            "                \"scheme\": \"VISA\",\n" +
            "                \"storedOnFile\": \"NOT_STORED\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"type\": \"CARD\"\n" +
            "    },\n" +
            "    \"status\": \"CAPTURED\",\n" +
            "    \"totalAuthorizedAmount\": 0.01,\n" +
            "    \"totalCapturedAmount\": 0.01,\n" +
            "    \"totalRefundedAmount\": 0.00,\n" +
            "    \"transaction\": [\n" +
            "        {\n" +
            "            \"3DSecure\": {\n" +
            "                \"acsEci\": \"05\",\n" +
            "                \"authenticationToken\": \"AAABACkEGSAJAhhEMQQZAAAAAAA=\",\n" +
            "                \"paResStatus\": \"Y\",\n" +
            "                \"veResEnrolled\": \"Y\",\n" +
            "                \"xid\": \"LALHeinyLRHAQA0vYinU3ze01iQ=\"\n" +
            "            },\n" +
            "            \"3DSecureId\": \"1599043464443\",\n" +
            "            \"authorizationResponse\": {\n" +
            "                \"cardLevelIndicator\": \"P \",\n" +
            "                \"cardSecurityCodeError\": \"M\",\n" +
            "                \"commercialCard\": \"!01\",\n" +
            "                \"commercialCardIndicator\": \"0\",\n" +
            "                \"date\": \"0902\",\n" +
            "                \"posData\": \"1025100006600\",\n" +
            "                \"posEntryMode\": \"812\",\n" +
            "                \"processingCode\": \"003000\",\n" +
            "                \"responseCode\": \"00\",\n" +
            "                \"returnAci\": \"M\",\n" +
            "                \"stan\": \"205614\",\n" +
            "                \"time\": \"104540\",\n" +
            "                \"transactionIdentifier\": \"380246387402517\",\n" +
            "                \"validationCode\": \"8WGB\",\n" +
            "                \"vpasResponse\": \"2\"\n" +
            "            },\n" +
            "            \"device\": {\n" +
            "                \"browser\": \"mozilla/5.0 (windows nt 6.1; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/85.0.4183.83 safari/537.36\",\n" +
            "                \"ipAddress\": \"119.139.197.88\"\n" +
            "            },\n" +
            "            \"gatewayEntryPoint\": \"WEB_SERVICES_API\",\n" +
            "            \"merchant\": \"020500073170\",\n" +
            "            \"order\": {\n" +
            "                \"amount\": 0.01,\n" +
            "                \"chargeback\": {\n" +
            "                    \"amount\": 0,\n" +
            "                    \"currency\": \"USD\"\n" +
            "                },\n" +
            "                \"creationTime\": \"2020-09-02T10:45:40.432Z\",\n" +
            "                \"currency\": \"USD\",\n" +
            "                \"customerOrderDate\": \"2020-09-02\",\n" +
            "                \"id\": \"200902184409258010255\",\n" +
            "                \"merchantCategoryCode\": \"5999\",\n" +
            "                \"reference\": \"200902184409258010255\",\n" +
            "                \"statementDescriptor\": {\n" +
            "                    \"name\": \"trendywigs\",\n" +
            "                    \"phone\": \"Miscellaneous\"\n" +
            "                },\n" +
            "                \"status\": \"CAPTURED\",\n" +
            "                \"totalAuthorizedAmount\": 0.01,\n" +
            "                \"totalCapturedAmount\": 0.01,\n" +
            "                \"totalRefundedAmount\": 0.00\n" +
            "            },\n" +
            "            \"response\": {\n" +
            "                \"acquirerCode\": \"00\",\n" +
            "                \"acquirerMessage\": \"Approved\",\n" +
            "                \"cardSecurityCode\": {\n" +
            "                    \"acquirerCode\": \"M\",\n" +
            "                    \"gatewayCode\": \"MATCH\"\n" +
            "                },\n" +
            "                \"gatewayCode\": \"APPROVED\"\n" +
            "            },\n" +
            "            \"result\": \"SUCCESS\",\n" +
            "            \"sourceOfFunds\": {\n" +
            "                \"provided\": {\n" +
            "                    \"card\": {\n" +
            "                        \"brand\": \"VISA\",\n" +
            "                        \"expiry\": {\n" +
            "                            \"month\": \"6\",\n" +
            "                            \"year\": \"21\"\n" +
            "                        },\n" +
            "                        \"fundingMethod\": \"CREDIT\",\n" +
            "                        \"issuer\": \"CHINA MERCHANTS BANK\",\n" +
            "                        \"number\": \"439226xxxxxx5920\",\n" +
            "                        \"scheme\": \"VISA\",\n" +
            "                        \"storedOnFile\": \"NOT_STORED\"\n" +
            "                    }\n" +
            "                },\n" +
            "                \"type\": \"CARD\"\n" +
            "            },\n" +
            "            \"timeOfRecord\": \"2020-09-02T10:45:40.443Z\",\n" +
            "            \"transaction\": {\n" +
            "                \"acquirer\": {\n" +
            "                    \"batch\": 20200902,\n" +
            "                    \"date\": \"0902\",\n" +
            "                    \"id\": \"UOB_S2I\",\n" +
            "                    \"merchantId\": \"020500073170\",\n" +
            "                    \"settlementDate\": \"2020-09-02\",\n" +
            "                    \"timeZone\": \"+0800\",\n" +
            "                    \"transactionId\": \"380246387402517\"\n" +
            "                },\n" +
            "                \"amount\": 0.01,\n" +
            "                \"authorizationCode\": \"180503\",\n" +
            "                \"currency\": \"USD\",\n" +
            "                \"frequency\": \"SINGLE\",\n" +
            "                \"id\": \"200902184409258010255\",\n" +
            "                \"receipt\": \"024610205614\",\n" +
            "                \"source\": \"INTERNET\",\n" +
            "                \"taxAmount\": 0.00,\n" +
            "                \"terminal\": \"UOBS2I01\",\n" +
            "                \"type\": \"PAYMENT\"\n" +
            "            },\n" +
            "            \"version\": \"50\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";


    private static final String SIMPLE_JSON = "{\n" +
            "    \"result\": \"SUCCESS\",\n" +
            "    \"sourceOfFunds\": {\n" +
            "        \"provided\": {\n" +
            "            \"card\": {\n" +
            "                \"brand\": \"VISA\",\n" +
            "                \"expiry\": {\n" +
            "                    \"month\": \"6\",\n" +
            "                    \"year\": \"21\"\n" +
            "                },\n" +
            "                \"fundingMethod\": \"CREDIT\",\n" +
            "                \"issuer\": \"CHINA MERCHANTS BANK\",\n" +
            "                \"number\": \"439226xxxxxx5920\",\n" +
            "                \"scheme\": \"VISA\",\n" +
            "                \"storedOnFile\": \"NOT_STORED\"\n" +
            "            }\n" +
            "        },\n" +
            "        \"type\": \"CARD\"\n" +
            "    }\n" +
            "}";


    /**
     * 简单报文
     * {
     *     "result": "SUCCESS",
     *     "sourceOfFunds": {
     *         "provided": {
     *             "card": {
     *                 "brand": "VISA",
     *                 "expiry": {
     *                     "month": "6",
     *                     "year": "21"
     *                 },
     *                 "fundingMethod": "CREDIT",
     *                 "issuer": "CHINA MERCHANTS BANK",
     *                 "number": "439226xxxxxx5920",
     *                 "scheme": "VISA",
     *                 "storedOnFile": "NOT_STORED"
     *             }
     *         },
     *         "type": "CARD"
     *     }
     * }
     */


    /**
     * 超级复杂测试报文
     * {
     *     "amount": 0.01,
     *     "chargeback": {
     *         "amount": 0,
     *         "currency": "USD"
     *     },
     *     "creationTime": "2020-09-02T10:45:40.432Z",
     *     "currency": "USD",
     *     "customerOrderDate": "2020-09-02",
     *     "device": {
     *         "browser": "mozilla/5.0 (windows nt 6.1; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/85.0.4183.83 safari/537.36",
     *         "ipAddress": "119.139.197.88"
     *     },
     *     "id": "200902184409258010255",
     *     "merchant": "020500073170",
     *     "merchantCategoryCode": "5999",
     *     "reference": "200902184409258010255",
     *     "result": "SUCCESS",
     *     "sourceOfFunds": {
     *         "provided": {
     *             "card": {
     *                 "brand": "VISA",
     *                 "expiry": {
     *                     "month": "6",
     *                     "year": "21"
     *                 },
     *                 "fundingMethod": "CREDIT",
     *                 "issuer": "CHINA MERCHANTS BANK",
     *                 "number": "439226xxxxxx5920",
     *                 "scheme": "VISA",
     *                 "storedOnFile": "NOT_STORED"
     *             }
     *         },
     *         "type": "CARD"
     *     },
     *     "status": "CAPTURED",
     *     "totalAuthorizedAmount": 0.01,
     *     "totalCapturedAmount": 0.01,
     *     "totalRefundedAmount": 0.00,
     *     "transaction": [
     *         {
     *             "3DSecure": {
     *                 "acsEci": "05",
     *                 "authenticationToken": "AAABACkEGSAJAhhEMQQZAAAAAAA=",
     *                 "paResStatus": "Y",
     *                 "veResEnrolled": "Y",
     *                 "xid": "LALHeinyLRHAQA0vYinU3ze01iQ="
     *             },
     *             "3DSecureId": "1599043464443",
     *             "authorizationResponse": {
     *                 "cardLevelIndicator": "P ",
     *                 "cardSecurityCodeError": "M",
     *                 "commercialCard": "!01",
     *                 "commercialCardIndicator": "0",
     *                 "date": "0902",
     *                 "posData": "1025100006600",
     *                 "posEntryMode": "812",
     *                 "processingCode": "003000",
     *                 "responseCode": "00",
     *                 "returnAci": "M",
     *                 "stan": "205614",
     *                 "time": "104540",
     *                 "transactionIdentifier": "380246387402517",
     *                 "validationCode": "8WGB",
     *                 "vpasResponse": "2"
     *             },
     *             "device": {
     *                 "browser": "mozilla/5.0 (windows nt 6.1; win64; x64) applewebkit/537.36 (khtml, like gecko) chrome/85.0.4183.83 safari/537.36",
     *                 "ipAddress": "119.139.197.88"
     *             },
     *             "gatewayEntryPoint": "WEB_SERVICES_API",
     *             "merchant": "020500073170",
     *             "order": {
     *                 "amount": 0.01,
     *                 "chargeback": {
     *                     "amount": 0,
     *                     "currency": "USD"
     *                 },
     *                 "creationTime": "2020-09-02T10:45:40.432Z",
     *                 "currency": "USD",
     *                 "customerOrderDate": "2020-09-02",
     *                 "id": "200902184409258010255",
     *                 "merchantCategoryCode": "5999",
     *                 "reference": "200902184409258010255",
     *                 "statementDescriptor": {
     *                     "name": "trendywigs",
     *                     "phone": "Miscellaneous"
     *                 },
     *                 "status": "CAPTURED",
     *                 "totalAuthorizedAmount": 0.01,
     *                 "totalCapturedAmount": 0.01,
     *                 "totalRefundedAmount": 0.00
     *             },
     *             "response": {
     *                 "acquirerCode": "00",
     *                 "acquirerMessage": "Approved",
     *                 "cardSecurityCode": {
     *                     "acquirerCode": "M",
     *                     "gatewayCode": "MATCH"
     *                 },
     *                 "gatewayCode": "APPROVED"
     *             },
     *             "result": "SUCCESS",
     *             "sourceOfFunds": {
     *                 "provided": {
     *                     "card": {
     *                         "brand": "VISA",
     *                         "expiry": {
     *                             "month": "6",
     *                             "year": "21"
     *                         },
     *                         "fundingMethod": "CREDIT",
     *                         "issuer": "CHINA MERCHANTS BANK",
     *                         "number": "439226xxxxxx5920",
     *                         "scheme": "VISA",
     *                         "storedOnFile": "NOT_STORED"
     *                     }
     *                 },
     *                 "type": "CARD"
     *             },
     *             "timeOfRecord": "2020-09-02T10:45:40.443Z",
     *             "transaction": {
     *                 "acquirer": {
     *                     "batch": 20200902,
     *                     "date": "0902",
     *                     "id": "UOB_S2I",
     *                     "merchantId": "020500073170",
     *                     "settlementDate": "2020-09-02",
     *                     "timeZone": "+0800",
     *                     "transactionId": "380246387402517"
     *                 },
     *                 "amount": 0.01,
     *                 "authorizationCode": "180503",
     *                 "currency": "USD",
     *                 "frequency": "SINGLE",
     *                 "id": "200902184409258010255",
     *                 "receipt": "024610205614",
     *                 "source": "INTERNET",
     *                 "taxAmount": 0.00,
     *                 "terminal": "UOBS2I01",
     *                 "type": "PAYMENT"
     *             },
     *             "version": "50"
     *         }
     *     ]
     * }
     */

}
