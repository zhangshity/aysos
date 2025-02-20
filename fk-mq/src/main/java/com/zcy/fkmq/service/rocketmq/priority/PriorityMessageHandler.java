package com.zcy.fkmq.service.rocketmq.priority;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class PriorityMessageHandler {

    public static void main(String[] args) throws Exception {
        // 高优先级消费者
        DefaultMQPushConsumer highPriorityConsumer = new DefaultMQPushConsumer("high_priority_consumer_group");
        highPriorityConsumer.setNamesrvAddr("localhost:9876");
        highPriorityConsumer.subscribe("SMS_PRIORITY_HIGH", "*");
        highPriorityConsumer.registerMessageListener(new HighPriorityListener());
        highPriorityConsumer.start();

        // 中优先级消费者
        DefaultMQPushConsumer mediumPriorityConsumer = new DefaultMQPushConsumer("medium_priority_consumer_group");
        mediumPriorityConsumer.setNamesrvAddr("localhost:9876");
        mediumPriorityConsumer.subscribe("SMS_PRIORITY_MEDIUM", "*");
        mediumPriorityConsumer.registerMessageListener(new MediumPriorityListener());
        mediumPriorityConsumer.start();

        // 低优先级消费者
        DefaultMQPushConsumer lowPriorityConsumer = new DefaultMQPushConsumer("low_priority_consumer_group");
        lowPriorityConsumer.setNamesrvAddr("localhost:9876");
        lowPriorityConsumer.subscribe("SMS_PRIORITY_LOW", "*");
        lowPriorityConsumer.registerMessageListener(new LowPriorityListener());
        lowPriorityConsumer.start();
    }

    private static class HighPriorityListener implements MessageListenerConcurrently {
        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            for (MessageExt msg : msgs) {
                sendSms(msg); // 假设这是发送短信的方法
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    }

    private static class MediumPriorityListener implements MessageListenerConcurrently {
        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            for (MessageExt msg : msgs) {
                sendSms(msg);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    }

    private static class LowPriorityListener implements MessageListenerConcurrently {
        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            for (MessageExt msg : msgs) {
                sendSms(msg);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
    }

    private static void sendSms(MessageExt msg) {
        // 模拟发送短信的业务逻辑
        System.out.printf("Sending SMS with content: %s%n", new String(msg.getBody()));
    }
}