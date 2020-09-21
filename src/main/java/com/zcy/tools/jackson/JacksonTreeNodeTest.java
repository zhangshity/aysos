package com.zcy.tools.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.zcy.tools.jackson.tool.BankReconciliationInfoBO;

public class JacksonTreeNodeTest {



    public static void main(String[] args) throws JsonProcessingException {
        String serviceResponse = "{\n" +
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



        //==================================解析XML===================================================================
        System.out.println("==================================解析XML===================================================================");
        String xml = "<xml>\n" +
                "    <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "    <return_msg><![CDATA[OK]]></return_msg>\n" +
                "    <appid><![CDATA[wx0dd3d8d451dd4907]]></appid>\n" +
                "    <mch_id><![CDATA[1499429942]]></mch_id>\n" +
                "    <sub_mch_id><![CDATA[321085262]]></sub_mch_id>\n" +
                "    <nonce_str><![CDATA[LYfJ5VzdagQ4sMJ7]]></nonce_str>\n" +
                "    <sign><![CDATA[36DBDB6892C462AA09B70FF984DF2663]]></sign>\n" +
                "    <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "    <openid><![CDATA[oM0WUwnlI7SzBDbznWQkfToFt59s]]></openid>\n" +
                "    <is_subscribe><![CDATA[N]]></is_subscribe>\n" +
                "    <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "    <bank_type><![CDATA[CITIC_DEBIT]]></bank_type>\n" +
                "    <total_fee>90000</total_fee>\n" +
                "    <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "    <transaction_id><![CDATA[4200000696202009208833664595]]></transaction_id>\n" +
                "    <out_trade_no><![CDATA[200920225106457168933]]></out_trade_no>\n" +
                "    <attach><![CDATA[200920225106457168933]]></attach>\n" +
                "    <time_end><![CDATA[20200920225115]]></time_end>\n" +
                "    <trade_state><![CDATA[SUCCESS]]></trade_state>\n" +
                "    <cash_fee>90000</cash_fee>\n" +
                "    <trade_state_desc><![CDATA[支付成功]]></trade_state_desc>\n" +
                "    <cash_fee_type><![CDATA[CNY]]></cash_fee_type>\n" +
                "    <rate><![CDATA[87520000]]></rate>\n" +
                "</xml>";
        ObjectMapper objectMapper1 = new XmlMapper();
        JsonNode root = objectMapper1.readTree(xml);
        String totalFee = root.get("total_fee").asText();
        String feeType = root.get("fee_type").asText();
        System.out.println(totalFee);
        System.out.println(feeType);

    }
}
