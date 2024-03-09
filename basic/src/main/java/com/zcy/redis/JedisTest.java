package com.zcy.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
/**
 * 官方UI客户端下载
 * https://download.redisinsight.redis.com/latest/RedisInsight-mac-x64.dmg
 */
public class JedisTest {
    public static void main(String[] args) {
        // -------- 2020 old code --------
        Jedis jedis = new Jedis("localhost");
        jedis.set("god", "com/zcy");
        System.out.println("redis 获取值: " + jedis.get("god"));
        jedis.close();

        // -------- 2024 new and best code --------
        Jedis jedis1 = new Jedis("localhost",6379); // closeable
        // 其他配置
        //jedis1.auth("123456"); //password
        //jedis1.select(0); //不填选默认
        // 操作
        jedis1.set("jedis:test:1", "test_value");
        jedis1.setex("jedis:test:2", 30, "test_value_2");
        jedis1.setnx("jedis:test:3", "test_value_3");
        jedis1.setnx("jedis:test:3", "test_value_3_1");
        jedis1.setnx("jedis:test:3", "test_value_3_2");
        jedis1.expire("jedis:test:3", 60 );
        // 关闭连接
        jedis1.close();


        // -------- 连接池 --------
        JedisPool pool = new JedisPool("localhost", 6379);
        try (Jedis jedisConn = pool.getResource()) { //jedis线程不安全，每个线程一个jedis对象保证安全
            jedisConn.setex("jedisPool:test:1", 60, "jedisPool");
            jedisConn.hset("jedisPool:test:hashes", "id", "21156");
            jedisConn.hset("jedisPool:test:hashes", "name", "allen");
            jedisConn.hset("jedisPool:test:hashes", "age", "18");
            jedisConn.hset("jedisPool:test:hashes", "age", "20");
            jedisConn.expire("jedisPool:test:hashes", 60);
            Map<String, String> hgetAll = jedisConn.hgetAll("jedisPool:test:hashes");
            System.out.println(hgetAll);
        }


        // -------- 更标准的连接池 --------
        try (Jedis jedisCli = JedisConnectionFactory.getJedis();){
            jedisCli.setex("jedisFactory:test:test1", 60, "123");
        }

    }




    /**
     * Jedis(客户端)工厂
     */
    static class JedisConnectionFactory{
        private static final JedisPool jedisPool;

        static {
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(8);
            jedisPoolConfig.setMaxIdle(8);
            jedisPoolConfig.setMinIdle(0);
            jedisPoolConfig.setMaxWaitMillis(1000);
            jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379,1000);
        }

        public static Jedis getJedis(){
            return jedisPool.getResource();
        }
    }

}
