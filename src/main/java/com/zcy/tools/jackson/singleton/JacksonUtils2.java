package com.zcy.tools.jackson.singleton;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/**
 * ObjectMapper单例工具类
 * <p>Title: JacksonUtils2</p>
 * <p>Description: 构建单例<code>ObjectMapper</code> (对象本身线程安全)</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2020-12-03 10:28:28
 */
public enum JacksonUtils2 {

    /**
     * 实例
     */
    INSTANCE;

    /**
     * 成员变量: 创建ObjectMapper对象
     */
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 构造函数: 配置ObjectMapper对象 - 防止精度丢失
     */
    JacksonUtils2() {
        // 防止精度丢失1: 创建JsonNode单例工厂时,指定使用decimalsAsIs(精确BigDecimal数值)实例.
        objectMapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
        // 防止精度丢失2: Float数据类型,使用BigDecimal反序列化.
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
    }

    /**
     * 公共方法 - 对外暴露获取单例ObjectMapper对象
     * @return ObjectMapper
     */
    public ObjectMapper getSingletonObjectMapper() {
        return objectMapper;
    }

}
