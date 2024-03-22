package com.zcy.collection.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    // 创建一个并发安全的消息队列
    private static final ConcurrentLinkedQueue<String> messageQueue = new ConcurrentLinkedQueue<>();


    // 生产者线程，模拟产生消息并放入队列
    public static class ProducerThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                String message = "Message_" + i;
                // 使用offer方法将消息放入队列，这是一个非阻塞的操作
                messageQueue.offer(message);
                System.out.println("Produced: " + message);
            }
        }
    }

    // 消费者线程，模拟从队列中取出并消费消息
    public static class ConsumerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                // 使用poll方法从队列中取出消息，如果没有消息则返回null，这也是一个非阻塞的操作
                String message = messageQueue.poll();
                if (message != null) {
                    System.out.println("Consumed: " + message);
                } else {
                    // 如果队列为空，可以做一些其他处理，如短暂休眠，此处为了简化示例不作处理
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建多个生产者线程
        for (int i = 0; i < 10; i++) {
            new ProducerThread().start();
        }

        // 创建多个消费者线程
        for (int i = 0; i < 5; i++) {
            new ConsumerThread().start();
        }
    }
}
