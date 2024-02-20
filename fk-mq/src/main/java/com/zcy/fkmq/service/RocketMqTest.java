package com.zcy.fkmq.service;

import org.apache.rocketmq.common.message.Message;

public class RocketMqTest {
    public static void main(String[] args) {

        Message message = new Message();
        message.setTopic("TopicTest");
        message.setBody("Hello World".getBytes());
        message.setTags("TagA");
        message.setKeys("KeyA");







    }
}
