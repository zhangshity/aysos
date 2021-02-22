package com.zcy.tools.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zcy.tools.jackson.enumeration.JacksonUtils;

import java.io.IOException;
import java.util.Optional;

public class JasonTreeNodeModify {
    public static void main(String[] args) throws IOException {
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
                "        \"amount\": 1.33,\n" +
                "        \"surcharge_amount\": 0.0,\n" +
                "        \"total_amount\": 1.33,\n" +
                "        \"currency\": \"AUD\"\n" +
                "    },\n" +
                "    \"response_code\": \"success\",\n" +
                "    \"response_message\": \"Your request has been successfully processed.\"\n" +
                "}";


        JsonNode root = JacksonUtils.getObjectMapper().readTree(bankResponse);
        System.out.println(root);
        JsonNode card = Optional.ofNullable(root.get("card")).orElse(null);

        if (card != null) {
            // 过略敏感信息
            String expiryMonthWithoutSensitiveInfo = Optional.ofNullable(card.get("expiry_month")).map(JsonNode::asText).map(x -> x.replaceAll("[0-9]", "*")).orElse(null);
            String expiryYearWithoutSensitiveInfo = Optional.ofNullable(card.get("expiry_year")).map(JsonNode::asText).map(x -> x.replaceAll("[0-9]", "*")).orElse(null);

            // 重新封装
            ((ObjectNode) card).put("expiry_month", expiryMonthWithoutSensitiveInfo)
                    .put("expiry_year", expiryYearWithoutSensitiveInfo);

            ((ObjectNode) root).set("card", card);

            JacksonUtils.getObjectMapper().writeValueAsString(root);
        }

        System.out.println(root.toString());
    }
}
