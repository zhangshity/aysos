package com.zcy.tools.jackson.tool;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

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
        ObjectMapper objectMapper = new ObjectMapper();
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


    public static void main(String[] args) throws IOException {

        String json = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"message\": \"ok\",\n" +
                "    \"data\": {\n" +
                "        \"bankTradeNo\": null,\n" +
                "        \"bankTransactionStatus\": 1,\n" +
                "        \"bankTransactionCurrency\": \"USD\",\n" +
                "        \"bankTransactionAmount\": 1,\n" +
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

        BankReconciliationInfoBO bankReconciliationInfoBO = JsonResultParseTool.parseJsonResultStringAsDataObject(json, BankReconciliationInfoBO.class);
        System.out.println(bankReconciliationInfoBO);

    }



}
