package com.zcy.tools.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcy.tools.jackson.enumeration.JacksonUtils;

import java.math.BigDecimal;
import java.util.Objects;

public class _ReadJacksonTreeNode {
    public static void main(String[] args) throws JsonProcessingException {

        String bankResponse = "{\n" +
                "    \"card\": {\n" +
                "        \"token\": null,\n" +
                "        \"multi_use\": false,\n" +
                "        \"number\": \"400000******0006\",\n" +
                "        \"expiry_month\": \"3\",\n" +
                "        \"expiry_year\": \"2023\",\n" +
                "        \"holder_name\": \"Donna Krezek\",\n" +
                "        \"brand\": \"visa\",\n" +
                "        \"funding\": \"credit\",\n" +
                "        \"country\": \"AU\"\n" +
                "    },\n" +
                "    \"customer\": {\n" +
                "        \"id\": null,\n" +
                "        \"authentication_redirect_url\": null\n" +
                "    },\n" +
                "    \"purchase\": {\n" +
                "        \"transaction_time_utc\": \"2021-02-22 03:50:51 AM\",\n" +
                "        \"status\": \"APPROVED\",\n" +
                "        \"purchase_reference\": \"713378497199902721\",\n" +
                "        \"amount\": 8791.3360,\n" +
                "        \"surcharge_amount\": null,\n" +
                "        \"total_amount\": 1.33,\n" +
                "        \"currency\": \"AUD\"\n" +
                "    },\n" +
                "    \"response_code\": \"success\",\n" +
                "    \"response_message\": \"Your request has been successfully processed.\"\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(bankResponse);
        // 不开启树节点精度配置，多余0依然会舍去 (下面方法会开启)
        //ObjectMapper objectMapper = JacksonUtils.getObjectMapper();
        //JsonNode root = objectMapper.readTree(bankResponse);

        // ========================================  读JSON text值 ========================================
        System.out.println("========================================  读JSON text值 ========================================");
        // 读JSON text值 (null)
        String id1 = root.get("customer").get("id").textValue(); //不是String,返回null (java关键字)
        String id2 = root.get("customer").get("id").asText();    //不是String,强制转换为String "null"
        System.out.println("id1=" + id1 + " id2=" + id2 + "    >>>>   id1 == id2 : " + Objects.equals(id1, id2));

        //读JSON text值 (number)
        String amount2 = root.get("purchase").get("amount").textValue(); //不是String,返回null (java关键字)
        String amount3 = root.get("purchase").get("amount").asText();    //不是String,强制转换为String, "8791.336"
        System.out.println(amount2 + " " + amount3);


        // ========================================  读JSON number值 ========================================
        System.out.println("========================================  读JSON number值 ========================================");
        //读JSON number值
        Number amount1 = root.get("purchase").get("amount").numberValue();                   //Number类型返回Number, 8791.336
        Number surchargeAmount = root.get("purchase").get("surcharge_amount").numberValue(); //不是Number类型返回null
        System.out.println(amount1 + " " + surchargeAmount);

        //读JSON number值 (decimalValue)
        BigDecimal amount4 = root.get("purchase").get("amount").decimalValue();                    //Number类型,自动转换为BigDecimal, 8791.336
        BigDecimal surchargeAmount2 = root.get("purchase").get("surcharge_amount").decimalValue(); //不是Number类型,自动Number转换为BigDecimal.ZERO, 0
        BigDecimal responseCode = root.get("response_code").decimalValue();                        //不是Number类型,自动Number转换为BigDecimal.ZERO, 0
        System.out.println(amount4 + " " + surchargeAmount2 + " " + responseCode);

        //读JSON number值 (doubleValue)
        double amount5 = root.get("purchase").get("amount").doubleValue();                    //Number类型,自动转换为double, 8791.336
        double surchargeAmount3 = root.get("purchase").get("surcharge_amount").doubleValue(); //不是Number类型,自动Number转换为double0.0, 0.0
        double responseCode2 = root.get("response_code").doubleValue();                       //不是Number类型,自动Number转换为double0.0, 0.0
        System.out.println(amount5 + " " + surchargeAmount3 + " " + responseCode2);

        //读JSON number值 (intValue)
        int amount6 = root.get("purchase").get("amount").intValue();                    //Number类型,自动转换为int, 8791
        int surchargeAmount4 = root.get("purchase").get("surcharge_amount").intValue(); //不是Number类型,自动Number转换为int0, 0
        int responseCode3 = root.get("response_code").intValue();                       //不是Number类型,自动Number转换为int0, 0
        System.out.println(amount6 + " " + surchargeAmount4 + " " + responseCode3);
    }
}
