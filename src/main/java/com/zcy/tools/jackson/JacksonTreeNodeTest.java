package com.zcy.tools.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcy.tools.jackson.tool.BankReconciliationInfoBO;

public class JacksonTreeNodeTest {



    public static void main(String[] args) throws JsonProcessingException {

        String serviceResponse = "{\"code\"};:\"0\",\"message\":\"ok\",\"data\":{\"bankTradeNo\":null,\"bankTransactionStatus\":1,\"bankTransactionCurrency\":\"USD\",\"bankTransactionAmount\":1,\"bankReturnCode\":\"80000\",\"bankInfo\":\"Transaction Approved\",\"responseCode\":null,\"responseQueryNo\":\"200828164713753016025\",\"bankCode\":null,\"bankMessage\":null,\"errorInfo\":null,\"tradeDate\":\"09/04/2020 03:44:31\"},\"sign\":null}\n";

        BankReconciliationInfoBO bankReconciliationInfoBO = null;
        // 2.-3 解析json报文
        ObjectMapper objectMapper = new ObjectMapper();
        // 2.-3.(1) 获取Json节点树,并判断取值
        JsonNode node = objectMapper.readTree(serviceResponse);
        String code = node.get("code").asText();
        String message = node.get("message").asText();
        // 2.-3.(2) 判断响应代码,如果成功data装换为实体类
        if ("0".equals(code) && "ok".equalsIgnoreCase(message)) {
            JsonNode data = node.get("data");
            bankReconciliationInfoBO = objectMapper.treeToValue(data, BankReconciliationInfoBO.class);
        } else {
            //logger.error("订单: {},{}微服务返回对账Json报文异常！", localReconciliationInfoBO.getTradeNo(), localReconciliationInfoBO.getTradeBankCode());
        }
    }
}
