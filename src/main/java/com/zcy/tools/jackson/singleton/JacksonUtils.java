package com.zcy.tools.jackson.singleton;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Jackson工具类
 * <p>Title: JacksonUtils</p>
 * <p>Description: 构建单例<code>ObjectMapper</code> (对象本身线程安全)</p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2020-12-03 10:28:28
 */
public enum JacksonUtils {

    /**
     * 实例
     */
    INSTANCE;

    private static final Logger logger = LoggerFactory.getLogger(JacksonUtils.class);

    /**
     * 成员变量: 创建ObjectMapper对象
     */
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 构造函数: 配置ObjectMapper对象 - 防止精度丢失
     */
    JacksonUtils() {
        // 防止精度丢失1: 创建JsonNode单例工厂时,指定使用decimalsAsIs(精确BigDecimal数值)实例.
        objectMapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
        // 防止精度丢失2: Float数据类型,使用BigDecimal反序列化.
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
    }

    /**
     * 公共方法: 对外暴露 - 获取单例ObjectMapper对象
     * @title getSingletonObjectMapper
     * @description 调用获取单例ObjectMapper对象
     * @author Allen.C.Y.Zhang
     * @time 2020-12-03 10:28:28
     * @return ObjectMapper 单例对象
     */
    public ObjectMapper getSingletonObjectMapper() {
        return objectMapper;
    }

    /**
     * 解析JsonResult字符串
     * @title jsonStringToObject
     * @description
     * @author Allen.C.Y.Zhang
     * @time 2020-12-03 10:28:28
     * @param jsonString JSON字符串
     * @param valueType  要转换成的对象类型
     * @return T 解析后对象
     */
    public  <T> T jsonStringToObject(String jsonString, Class<T> valueType){
        T object = null;
        try {
            object = objectMapper.readValue(jsonString, valueType);
        } catch (IOException e) {
            logger.error("解析JSON字符串为对象异常:", e);
        }
        return object;
    }

    /**
     * 转化对象为JSON字符串
     * @title toJsonString
     * @description
     * @author Allen.C.Y.Zhang
     * @time 2020-12-03 10:28:28
     * @param object 要转换成的对象类型
     * @return String 转化后的JSON字符串
     */
    public String toJsonString(Object object) {
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("转化对象为JSON字符串异常:", e);
        }
        return jsonString;
    }
}
