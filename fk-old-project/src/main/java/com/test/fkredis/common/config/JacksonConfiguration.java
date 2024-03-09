package com.test.fkredis.common.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

/**
 * Jackson配置
 * <p>Title: JacksonConfiguration </p>
 * <p>Description: 扩展SpringBoot集成Jackson </p>
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-03-17 21:20
 */
@Configuration
public class JacksonConfiguration {

    /**
     * Jackson-XML格式Http报文开启Declaration(Prolog)
     * @param builder Mapper构建器
     * @return {@link MappingJackson2XmlHttpMessageConverter}序列化xml转换器
     */
    @Bean
    public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter(Jackson2ObjectMapperBuilder builder) {
        XmlMapper xmlMapper = builder.createXmlMapper(true).build();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        return new MappingJackson2XmlHttpMessageConverter(xmlMapper);
    }
}
