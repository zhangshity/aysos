package com.zcy.tools.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.zcy.tools.jackson.singleton.JacksonUtils;
import com.zcy.tools.jackson.tool.BankReconciliationInfoBO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class JacksonTreeNodeTest {



    public static void main(String[] args) throws JsonProcessingException {
        String serviceResponse = "{\n" +
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
        BankReconciliationInfoBO bankReconciliationInfoBO = null;
        // 2.-3 解析json报文
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        objectMapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));

        // 2.-3.(1) 获取Json节点树,并判断取值
        JsonNode node = objectMapper.readTree(serviceResponse);

        System.out.println(node.toPrettyString());

        String code = node.get("code").asText();
        String message = node.get("message").asText();
        // 2.-3.(2) 判断响应代码,如果成功data装换为实体类
        if ("0".equals(code) && "ok".equalsIgnoreCase(message)) {
            JsonNode data = node.get("data");
            bankReconciliationInfoBO = objectMapper.treeToValue(data, BankReconciliationInfoBO.class);
        } else {
            //logger.error("订单: {},{}微服务返回对账Json报文异常！", localReconciliationInfoBO.getTradeNo(), localReconciliationInfoBO.getTradeBankCode());
        }

        //======================== 反序列化测试 =======================
        System.out.println("======================== 反序列化测试 =======================");
        System.out.println(bankReconciliationInfoBO);

        //JasonNode节点测试 精度丢失问题  Deserializing BigDecimal using JsonNode loses precision #2087
        //https://github.com/FasterXML/jackson-databind/issues/2087
        // 草拟吗的搞半天。也不修复 傻逼 jackson



        //======================== 序列化测试 =======================
        System.out.println("======================== 序列化测试 =======================");
        BankReconciliationInfoBO bankReconciliationInfoBO1 = new BankReconciliationInfoBO();
        bankReconciliationInfoBO1.setBankTransactionAmount(new BigDecimal("155.000"));
        System.out.println(objectMapper.writeValueAsString(bankReconciliationInfoBO1));




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






        //================================== Map转换成Json字符串 ===================================================================
        System.out.println("================================== Map转换成Json字符串 ===================================================================");
        Map<String, String> requestParametersMap = new HashMap<>(16);
        requestParametersMap.put("channel_type", "overseas");
        requestParametersMap.put("format", "json");
        requestParametersMap.put("nonce_str", "asdasdasADJFNH");
        requestParametersMap.put("org_id", "123");
        requestParametersMap.put("out_trans_id", "20555049841123141243265");
        requestParametersMap.put("service", "ccc.cc.mm.as");
        requestParametersMap.put("sign", "aasd6521465+4d1refasf1");
        requestParametersMap.put("sign_type", "md5");
        requestParametersMap.put("timestamp", "10055151612");
        requestParametersMap.put("version", "1.0");
        String requestParameters = JacksonUtils.INSTANCE.toJsonString(requestParametersMap);
        System.out.println(requestParameters);










        //================================== 空Json字符串NPE测试 ===================================================================
        System.out.println("================================== 空Json字符串NPE测试 ===================================================================");
        String json = "{}";   //空json可以解析成 {}
        //String json = "";     //空""字符串可以解析成""
        //String json ="{"      //格式错误爆出异常
        ObjectMapper objectMapper2 = JacksonUtils.INSTANCE.getSingletonObjectMapper();
        JsonNode root2 = objectMapper2.readTree(json);
        System.out.println(root2);

        JsonNode something = root2.get("something");
        System.out.println(something); //null
    }
}
