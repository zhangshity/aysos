package com.zcy.serialize.jackson_serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zcy.tools.jackson.singleton.JacksonUtils2;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        // mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        /*
            mapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
            mapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
            mapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        */


        Bean1 bean1 = new Bean1("haha1", new BigDecimal("1.00"));
        Bean2 bean2 = new Bean2("haha2", new BigDecimal("2.00"));

        String bs1 = mapper.writeValueAsString(bean1);
        String bs2 = mapper.writeValueAsString(bean2);
        System.out.println("序列化对象,得到Json字符串: " + bs1);
        System.out.println("序列化对象,得到Json字符串: " + bs2);

        Bean1 b1 = mapper.readValue(bs1, Bean1.class);
        Bean2 b2 = mapper.readValue(bs2, Bean2.class);
        System.out.println("反序列化到对象: " + b1);
        System.out.println("反序列化到对象: " + b2);





        //================================= ObjectMapper 单例 配置 序列化/反序列化 测试 ============================
        System.out.println("======================= ObjectMapper 单例 配置 序列化/反序列化 测试====================");
        //获取单例ObjectMapper
        ObjectMapper objectMapper = JacksonUtils2.INSTANCE.getSingletonObjectMapper();

        /*
            ObjectReader reader = objectMapper.reader();
            JsonNode root = reader.readTree(json);
        */

        String json = "{\"p1\":\"haha1\",\"p2\":365.0000}";
        System.out.println("Json字符串: " + json + "\n");


        // 读取到JsonNode
        JsonNode root = objectMapper.readTree(json);
        System.out.println("Json字符串 - 读取到树形节点: \n" + root.toPrettyString() + "\n");

        // 反序列化到对象
        Bean1 beanDeserialize = objectMapper.readValue(json, Bean1.class);
        System.out.println("Json字符串: - 反序列化到对象: " + beanDeserialize + "\n");

    }
}
