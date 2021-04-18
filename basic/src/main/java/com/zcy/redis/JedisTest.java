package com.zcy.redis;

import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("localhost");
        jedis.set("god", "com/zcy");

        System.out.println("redis 获取值: " + jedis.get("god"));

    }
}
