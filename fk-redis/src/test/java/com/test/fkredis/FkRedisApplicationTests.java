package com.test.fkredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class FkRedisApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate; // 一般使用此类，序列化手动转换为json字符串，反序列化手动解析为java对象

    @Test
    void testRedisTemplate() {
        // ------ string ------
        // key-string/value-jackson
        String stringKey1 = "redis_template:string:json_value";
        redisTemplate.opsForValue().set(stringKey1, "redis_template's string value", 60000, TimeUnit.MILLISECONDS);
        Object json = redisTemplate.opsForValue().get(stringKey1);
        System.out.println(json); //redis实际存储 "redis_template's string value"
        // key-string/value-string
        String stringkey2 = "redis_template:string:sting_value";
        stringRedisTemplate.opsForValue().set(stringkey2, "redis_template's string value", 60000, TimeUnit.MILLISECONDS);
        String string = stringRedisTemplate.opsForValue().get(stringkey2);
        System.out.println(string); //redis实际存储 redis_template's string value

        // ------ hash ------
        // key-string/value-jackson
        String hashKey1 = "redis_template:hash:json_value";
        redisTemplate.opsForHash().put(hashKey1, "desc", "redis_template's hash value");
        redisTemplate.expire(hashKey1, 60000, TimeUnit.MILLISECONDS);
        Object descJson = redisTemplate.opsForHash().get(hashKey1, "desc");
        System.out.println(descJson); //redis实际存储 "redis_template's hash value"
        // key-string/value-string
        String hashKey2 = "redis_template:hash:sting_value";
        stringRedisTemplate.opsForHash().put(hashKey2, "desc", "redis_template's hash value");
        stringRedisTemplate.expire(hashKey2, 60000, TimeUnit.MILLISECONDS);
        Object descString = stringRedisTemplate.opsForHash().get(hashKey2, "desc");
        System.out.println(descString); //redis实际存储 redis_template's hash value

        // ------ list ------
        // key-string/value-jackson
        String listKey1 = "redis_template:list:json_value";
        redisTemplate.opsForList().leftPush(listKey1, "123");
        redisTemplate.opsForList().leftPushIfPresent(listKey1, "abc");
        redisTemplate.opsForList().leftPushAll(listKey1, "456", "789", "101112");
        redisTemplate.expire(listKey1, 60000, TimeUnit.MILLISECONDS);
        List<Object> rangeJson = redisTemplate.opsForList().range(listKey1, 0, 100);
        System.out.println(rangeJson); //redis实际存储 ["101112", "789", "456", "abc", "123"]
        // key-string/value-string
        String listKey2 = "redis_template:list:sting_value";
        stringRedisTemplate.opsForList().leftPush(listKey2, "123");
        stringRedisTemplate.opsForList().leftPushIfPresent(listKey2, "abc");
        stringRedisTemplate.opsForList().leftPushAll(listKey2, "456", "789", "101112");
        stringRedisTemplate.expire(listKey2, 60000, TimeUnit.MILLISECONDS);
        List<String> rangeString = stringRedisTemplate.opsForList().range(listKey2, 0, 100);
        System.out.println(rangeString); //redis实际存储 [101112, 789, 456, abc, 123]

        // ------ set ------
        // key-string/value-jackson
        String setKey1 = "redis_template:set:json_value";
        redisTemplate.opsForSet().add(setKey1, "s123", 123, 456, "s456");
        redisTemplate.expire(setKey1, 60000, TimeUnit.MILLISECONDS);
        Set<Object> members1 = redisTemplate.opsForSet().members(setKey1);
        System.out.println(members1); //redis实际存储 ["s456", 456, 123, "s123"]
        // key-string/value-string
        String setKey2 = "redis_template:set:string_value";
        stringRedisTemplate.opsForSet().add(setKey2, "s123", "123", "456", "s456"); //数字必须字符串(不然编译错误)
        stringRedisTemplate.expire(setKey2, 60000, TimeUnit.MILLISECONDS);
        Set<String> members2 = stringRedisTemplate.opsForSet().members(setKey2);
        System.out.println(members2); //redis实际存储 [s456, 456, 123, s123]

        // ------ zset ------
        // key-string/value-jackson
        String zSetKey1 = "redis_template:zset:json_value";
        redisTemplate.opsForZSet().add(zSetKey1, "z123", 1);
        redisTemplate.opsForZSet().add(zSetKey1, "z456", 2.5);
        ZSetOperations.TypedTuple<Object> v3 = new DefaultTypedTuple<>("z789", 3D);
        ZSetOperations.TypedTuple<Object> v4 = new DefaultTypedTuple<>("z101112", 4D);
        Set<ZSetOperations.TypedTuple<Object>> vSet = new HashSet<>();
        vSet.add(v3);
        vSet.add(v4);
        redisTemplate.opsForZSet().add(zSetKey1, vSet);
        redisTemplate.expire(zSetKey1, 60000, TimeUnit.MILLISECONDS);
        Set<Object> range1 = redisTemplate.opsForZSet().range(zSetKey1, 0, 100);
        System.out.println(range1); //redis实际存储 ["z123", "z456", "z789", "z101112"]
        Set<Object> revRange1 = redisTemplate.opsForZSet().reverseRange(zSetKey1, 0, 100);
        System.out.println(revRange1); //redis实际存储 ["z101112", "z789", "z456", "z123"]
        // key-string/value-string
        String zSetKey2 = "redis_template:zset:string_value";
        stringRedisTemplate.opsForZSet().add(zSetKey2, "z123", 1);
        stringRedisTemplate.opsForZSet().add(zSetKey2, "z456", 2.5);
        ZSetOperations.TypedTuple<String> v5 = new DefaultTypedTuple<>("z789", 3D);
        ZSetOperations.TypedTuple<String> v6 = new DefaultTypedTuple<>("z101112", 4D);
        Set<ZSetOperations.TypedTuple<String>> vSet2 = new HashSet<>();
        vSet2.add(v5);
        vSet2.add(v6);
        stringRedisTemplate.opsForZSet().add(zSetKey2, vSet2);
        stringRedisTemplate.expire(zSetKey2, 60000, TimeUnit.MILLISECONDS);
        Set<String> range2 = stringRedisTemplate.opsForZSet().range(zSetKey2, 0, 100);
        System.out.println(range2); //redis实际存储 [z123, z456, z789, z101112]
        Set<String> revRange2 = stringRedisTemplate.opsForZSet().reverseRange(zSetKey2, 0, 100);
        System.out.println(revRange2); //redis实际存储 [z101112, z789, z456, z123]
    }

    @Test
    void testStringRedisTemplateManualSerialization() throws JsonProcessingException {
        User user = new User();
        user.setId(1L);
        user.setName("Allen");
        user.setAge(18);

        // ------> 使用RedisTemplate 自动序列化/反序列化
        redisTemplate.opsForValue().set("manual_Serialization:json", user, 60000, TimeUnit.MILLISECONDS);
        Object json = redisTemplate.opsForValue().get("manual_Serialization:json");
        System.out.println(json); //redis实际存储 {"@class":"com.test.fkredis.FkRedisApplicationTests$User","id":1,"name":"Allen","age":18}

        //  "@class":"com.test.fkredis.FkRedisApplicationTests$User"
        // 是Jackson序列化时的特殊标记，用于反序列化时找到对应的类
        // 但是这样的序列化/反序列化会导致redis中的数据不易阅读，且不易迁移，内存空间占用大，数据量大时不友好


        // -------> 使用StringRedisTemplate 手动序列化/反序列化
        ObjectMapper om = new ObjectMapper();
        String userJsonStr = om.writeValueAsString(user); //序列化
        stringRedisTemplate.opsForValue().set("manual_Serialization:string", userJsonStr, 60000, TimeUnit.MILLISECONDS);
        String result = stringRedisTemplate.opsForValue().get("manual_Serialization:string");
        User deserializedUserObj = om.readValue(result, User.class); //反序列化
        System.out.println(deserializedUserObj); //redis实际存储 {"id":1,"name":"Allen","age":18}

    }


    @Data
    static class User {
        private Long id;
        private String name;
        private Integer age;
    }
}
