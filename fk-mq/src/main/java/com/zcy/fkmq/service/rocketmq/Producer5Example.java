package com.zcy.fkmq.service.rocketmq;

import org.apache.rocketmq.client.apis.ClientConfiguration;
import org.apache.rocketmq.client.apis.ClientConfigurationBuilder;
import org.apache.rocketmq.client.apis.ClientException;
import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *      ### 启动namesrv
 *      nohup sh bin/mqnamesrv &
 *
 *      ### 验证namesrv是否启动成功
 *      tail -f ~/logs/rocketmqlogs/namesrv.log
 *      The Name Server boot success...
 *
 *
 *
 *
 *      ### 先启动broker
 *      nohup sh bin/mqbroker -n localhost:9876 --enable-proxy &
 *
 *      ### 验证broker是否启动成功, 比如, broker的ip是192.168.1.2 然后名字是broker-a
 *      tail -f ~/logs/rocketmqlogs/proxy.log
 *      The broker[broker-a,192.169.1.2:10911] boot success...
 *
 *
 *
 *      ### 通过mqadmin创建 Topic。
 *      sh bin/mqadmin updatetopic -n localhost:9876 -t TestTopic -c DefaultCluster
 * </pre>
 */
public class Producer5Example {
    private static final Logger logger = LoggerFactory.getLogger(Producer5Example.class);

    public static void main(String[] args) throws ClientException {
        // 接入点地址，需要设置成Proxy的地址和端口列表，一般是xxx:8080;xxx:8081。
        String endpoint = "localhost:8081";
        // 消息发送的目标Topic名称，需要提前创建。
        String topic = "TestTopic";
        ClientServiceProvider provider = ClientServiceProvider.loadService();
        ClientConfigurationBuilder builder = ClientConfiguration.newBuilder().setEndpoints(endpoint);
        ClientConfiguration configuration = builder.build();
        // 初始化Producer时需要设置通信配置以及预绑定的Topic。
        Producer producer = provider.newProducerBuilder()
                .setTopics(topic)
                .setClientConfiguration(configuration)
                .build();
        // 普通消息发送。
        Message message = provider.newMessageBuilder()
                .setTopic(topic)
                // 设置消息索引键，可根据关键字精确查找某条消息。
                .setKeys("messageKey")
                // 设置消息Tag，用于消费端根据指定Tag过滤消息。
                .setTag("messageTag")
                // 消息体。
                .setBody("messageBody".getBytes())
                .build();
        try {
            // 发送消息，需要关注发送结果，并捕获失败等异常。
            SendReceipt sendReceipt = producer.send(message);
            logger.info("Send message successfully, messageId={}", sendReceipt.getMessageId());
        } catch (ClientException e) {
            logger.error("Failed to send message", e);
        }
        // producer.close();
    }
}