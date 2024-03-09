package com.test.fkredis.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redis配置
 *
 * @author Allen.C.Y.Zhang
 * @see RedisTemplate#afterPropertiesSet()
 * @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
 * @since 2024-03-09
 */
@Configuration
public class RedisConfiguration {

    @Bean("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 初始化
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        // 连接配置 (默认)
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 序列化配置
        redisTemplate.setKeySerializer(RedisSerializer.string()); //Key String序列化
        redisTemplate.setValueSerializer(RedisSerializer.json()); //Value Json序列化
        redisTemplate.setHashKeySerializer(RedisSerializer.string()); //HashKey String序列化
        redisTemplate.setHashValueSerializer(RedisSerializer.json()); //HashKey Json序列化

        return redisTemplate;
    }

}
