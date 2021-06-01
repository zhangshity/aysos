package com.zcy.tools.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.zcy.tools.jackson.singleton.JacksonUtils;

public class JacksonArrayTest {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\n" +
                "    \"code\": 4011,\n" +
                "    \"msg\": \"Match multiple logistics providers.\",\n" +
                "    \"data\": \"[{\\\"carrierCode\\\":\\\"au_post\\\",\\\"carrierNameCn\\\":\\\"澳大利亚邮政\\\",\\\"carrierNameEn\\\":\\\"Australia Post\\\"},{\\\"carrierCode\\\":\\\"pyexpress\\\",\\\"carrierNameCn\\\":\\\"派优供应链\\\",\\\"carrierNameEn\\\":\\\"PY Express\\\"}]\"\n" +
                "}";


        ObjectMapper objectMapper = JacksonUtils.INSTANCE.getSingletonObjectMapper();


        ObjectMapper mapper = JsonMapper.builder().enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER).build();
        JsonNode root1 = mapper.readTree(json);
        System.out.println(root1.get("data"));




        JsonNode root = objectMapper.readTree(json);
        JsonNode data = root.get("data");
        JsonNode retreeify = objectMapper.readTree(data.asText());



        System.out.println(retreeify);



        for (JsonNode node : data) {
            System.out.println(node.get("carrierCode").asText());
        }

//        =Optional.ofNullable(root).map(x -> x.get("data")).map(JsonNode::asText).map(x->x.);
//
//        String
//
//        System.out.println(data);


        JsonNode node = com.zcy.tools.jackson.enumeration.JacksonUtils.getObjectMapper().readTree(json);
        System.out.println(node.isArray()); //false
        System.out.println(node.get("data").isArray()); //false


        String json2 = "{\n" +
                "\"name\":\"Bill Gates\",\n" +
                "\"age\":62,\n" +
                "\"cars\":[ \"Porsche\", \"BMW\", \"Volvo\" ]\n" +
                "}";
        JsonNode node2 = com.zcy.tools.jackson.enumeration.JacksonUtils.getObjectMapper().readTree(json2);
        System.out.println(node2.isArray()); //false
        System.out.println(node2.get("cars").isArray()); //true


        String json3 = "{\n" +
                "    \"name\": \"Bill Gates\",\n" +
                "    \"age\": 62,\n" +
                "    \"cars\": [\n" +
                "       { \"name\": \"Porsche\",  \"models\": [ \"911\", \"Taycan\" ] },\n" +
                "       { \"name\": \"BMW\", \"models\": [ \"M5\", \"M3\", \"X5\" ] },\n" +
                "       { \"name\": \"Volvo\", \"models\": [ \"XC60\", \"V60\" ] }\n" +
                "    ]\n" +
                "}";
        JsonNode node3 = com.zcy.tools.jackson.enumeration.JacksonUtils.getObjectMapper().readTree(json3);
        System.out.println(node3.isArray()); //false
        System.out.println(node3.get("cars").isArray()); //true
    }
}
