package com.zcy.tools.jackson.enumeration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        String jsonString = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"message\": \"ok\",\n" +
                "    \"data\": {\n" +
                "        \"bankTradeNo\": null,\n" +
                "        \"bankTransactionStatus\": 1,\n" +
                "        \"bankTransactionCurrency\": \"USD\",\n" +
                "        \"bankTransactionAmount\": 105.000,\n" +
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


        ObjectMapper objectMapper = JacksonUtils.getObjectMapper();
        ObjectMapper objectMapper1 = JacksonUtils.getObjectMapper();
        System.out.println(objectMapper == objectMapper1);

        JsonNode root = objectMapper.readTree(jsonString);
        BigDecimal amount = new BigDecimal(root.get("data").get("bankTransactionAmount").asText());
        System.out.println(amount);


        ObjectReader reader= objectMapper.reader();
        BigDecimal amount2 = new BigDecimal(reader.readTree(jsonString).get("data").get("bankTransactionAmount").asText());
        System.out.println(amount2);

    }
}
