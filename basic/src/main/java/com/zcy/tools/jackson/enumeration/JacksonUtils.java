package com.zcy.tools.jackson.enumeration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.io.IOException;

/**
 * Jackson工具类
 * <p>Title: JacksonUtils</p>
 * <p>Description: 构建单例{@link ObjectMapper}(对象本身线程安全)</p>
 * @author Allen.C.Y.Zhang
 * @date 2020-12-03 10:28:28
 * @since 1.8
 * @see com.zcy.desgin_pattern.singleton.enumeration.EnumSingleton
 */
public class JacksonUtils {

    private JacksonUtils() {
    }

    private enum SingletonHolder {
        INSTANCE;
        private final ObjectMapper objectMapper;

        SingletonHolder() {
            objectMapper = new ObjectMapper();
            // 防止精度丢失1: 创建JsonNode单例工厂时,指定使用decimalsAsIs(精确BigDecimal数值)实例.
            objectMapper.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));
            // 防止精度丢失2: Float数据类型,使用BigDecimal反序列化.
            objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        }
    }

    /**
     * 获取单例ObjectMapper对象
     * @author Allen.C.Y.Zhang
     * @date 2020-12-03 10:28:28
     * @return ObjectMapper 单例对象
     */
    public static ObjectMapper getObjectMapper() {
        return SingletonHolder.INSTANCE.objectMapper;
    }

    /**
     * 解析JsonResult字符串
     * - 可能会抛出{@link RuntimeException}异常,需要调用者自行处理
     * @author Allen.C.Y.Zhang
     * @date 2020-12-03 10:28:28
     * @param jsonString JSON字符串
     * @param valueType  要转换成的对象类型
     * @return T 解析后对象
     */
    public static <T> T jsonToObject(String jsonString, Class<T> valueType) {
        T object = null;
        try {
            object = getObjectMapper().readValue(jsonString, valueType);
        } catch (IOException e) {
            throw new RuntimeException("解析JSON字符串为对象异常", e);
        }
        return object;
    }

    /**
     * 转化对象为JSON字符串
     * - 可能会抛出{@link RuntimeException}异常,需要调用者自行处理
     * @author Allen.C.Y.Zhang
     * @date 2020-12-03 10:28:28
     * @param object 要转换成的对象类型
     * @return String 转化后的JSON字符串
     */
    public static String objectToJson(Object object) {
        String jsonString = null;
        try {
            jsonString = getObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("转化对象为JSON字符串异常:", e);
        }
        return jsonString;
    }
}
