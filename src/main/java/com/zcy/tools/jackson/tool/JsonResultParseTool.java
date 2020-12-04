package com.zcy.tools.jackson.tool;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.zcy.tools.jackson.singleton.JacksonUtils;
import com.zcy.tools.jackson.singleton.JacksonUtils2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonResultParseTool {

    /**
     * 解析JsonResult字符串
     * @Title parseJsonResultString
     * @Description JsonResult通过Json字符串形式网络传输,需要解析成对象
     * @param jsonResultString JsonResult的字符串形式
     * @param valueType 要转换成的对象类型
     * @return Object 解析后对象
     * @throws IOException 异常
     */
    public static <T> T parseJsonResultStringAsDataObject(String jsonResultString, Class<T> valueType) throws IOException {
        /*
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
            objectMapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
        */
        ObjectMapper objectMapper = JacksonUtils2.INSTANCE.getSingletonObjectMapper();
        JsonNode node = objectMapper.readTree(jsonResultString);
        String code = node.get("code").asText();
        String message = node.get("message").asText();
        // 判断响应代码,如果成功data装换为实体类
        if ("0".equals(code) && "ok".equalsIgnoreCase(message)) {
            JsonNode data = node.get("data");
            return objectMapper.treeToValue(data, valueType);
        }
        return null;
    }

    /**
     * 解析JsonResult字符串
     *
     * @param jsonResultString JsonResult的字符串形式
     * @param valueType        要转换成的对象类型
     * @return List<T> 解析后对象List
     * @throws IOException 异常
     * @Title parseJsonResultString
     * @Description JsonResult通过Json字符串形式网络传输, 需要解析成对象List
     */
    public static <T> List<T> parseJsonResultStringAsList(String jsonResultString, Class<T> valueType) throws IOException {
        /*
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
            objectMapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
        */
        ObjectMapper objectMapper = JacksonUtils.INSTANCE.getSingletonObjectMapper();
        JsonNode node = objectMapper.readTree(jsonResultString);
        String code = node.get("code").asText();
        String message = node.get("message").asText();
        // 判断响应代码,如果成功data装换为实体类
        if ("0".equals(code) && "ok".equalsIgnoreCase(message)) {
            List<T> resultList = new ArrayList<>();
            JsonNode dataArray = node.get("data");
            for (JsonNode data : dataArray) {
                resultList.add(objectMapper.treeToValue(data, valueType));
            }
            return resultList;
        }
        return null;
    }







    public static void main(String[] args) throws IOException {

        String json = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"message\": \"ok\",\n" +
                "    \"data\": {\n" +
                "        \"bankTradeNo\": null,\n" +
                "        \"bankTransactionStatus\": 1,\n" +
                "        \"bankTransactionCurrency\": \"USD\",\n" +
                "        \"bankTransactionAmount\": 857.0000,\n" +
                "        \"bankReturnCode\": \"80000\",\n" +
                "        \"bankInfo\": \"Transaction Approved\",\n" +
                "        \"responseCode\": null,\n" +
                "        \"responseQueryNo\": \"200828164713753016025\",\n" +
                "        \"bankCode\": null,\n" +
                "        \"bankMessage\": null,\n" +
                "        \"errorInfo\": null,\n" +
                "        \"tradeDate\": \"09/04/2020 03:44:31\"\n" +
                "    },\n" +
                "    \"sign\": null\n" +
                "}";


        String json2 = "{\n" +
                "  \"code\": \"0\",\n" +
                "  \"message\": \"ok\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"bankTradeNo\": null,\n" +
                "      \"bankTransactionStatus\": 1,\n" +
                "      \"bankTransactionCurrency\": \"USD\",\n" +
                "      \"bankTransactionAmount\": 123.0000,\n" +
                "      \"bankReturnCode\": \"80099\",\n" +
                "      \"bankInfo\": \"Transaction was rejected by bank\",\n" +
                "      \"responseCode\": null,\n" +
                "      \"responseQueryNo\": \"200902184734399126121\",\n" +
                "      \"bankCode\": null,\n" +
                "      \"bankMessage\": null,\n" +
                "      \"errorInfo\": null,\n" +
                "      \"tradeDate\": \"09/02/2020 10:52:03\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"bankTradeNo\": null,\n" +
                "      \"bankTransactionStatus\": 2,\n" +
                "      \"bankTransactionCurrency\": \"CNY\",\n" +
                "      \"bankTransactionAmount\": 589.0,\n" +
                "      \"bankReturnCode\": \"80000\",\n" +
                "      \"bankInfo\": \"Transaction Approved\",\n" +
                "      \"responseCode\": null,\n" +
                "      \"responseQueryNo\": \"200902184734399126122\",\n" +
                "      \"bankCode\": null,\n" +
                "      \"bankMessage\": null,\n" +
                "      \"errorInfo\": null,\n" +
                "      \"tradeDate\": \"09/02/2020 11:52:03\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"sign\": null\n" +
                "}";



        // 解析Json成普通对象
        BankReconciliationInfoBO bankReconciliationInfoBO = JsonResultParseTool.parseJsonResultStringAsDataObject(json, BankReconciliationInfoBO.class);
        System.out.println(bankReconciliationInfoBO);


        System.out.println("\n");


        // 解析Json数组成List
        List<BankReconciliationInfoBO> list = JsonResultParseTool.parseJsonResultStringAsList(json2, BankReconciliationInfoBO.class);
        System.out.println(list);

    }



}
