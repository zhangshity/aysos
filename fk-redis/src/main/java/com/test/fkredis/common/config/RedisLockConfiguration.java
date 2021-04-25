package com.test.fkredis.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.integration.redis.util.RedisLockRegistry;

/**
 * RedisLock配置
 * <p>Title: RedisLockConfiguration
 * <p>Description: Redis Distributed Lock
 * @author Allen.C.Y.Zhang
 * @version V1.0
 * @date 2021-04-09 09:41
 */
@Configuration
public class RedisLockConfiguration {

    @Bean
    public RedisLockRegistry redisLockRegistry(RedisConnectionFactory redisConnectionFactory) {
        return new RedisLockRegistry(redisConnectionFactory,"op-gateway");
    }
}
