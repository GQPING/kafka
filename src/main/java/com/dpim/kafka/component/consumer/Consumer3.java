package com.dpim.kafka.component.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;

/**
 * @author cxw
 * @date 2022/1/26
 */
@Slf4j
@Component
public class Consumer3 {
    /**
     * 测试主题
     */
    private static String TOPIC = "kafka-test-topic";

    /**
     * 并发执行计数器
     */
    private CountDownLatch latch = new CountDownLatch(1);

    /**
     * 获取消费消息数量
     */
    public CountDownLatch getLatch() {
        return latch;
    }

    /**
     * 消费一个消息
     */
//    @KafkaListener(topics = "${spring.kafka.topic.test_group1}")
//    public void consumer(ConsumerRecord consumerRecord) {
//        Optional kafkaMsg = Optional.ofNullable(consumerRecord.value());
//        if (kafkaMsg.isPresent()) {
//            latch.countDown();
//            Object msg = kafkaMsg.get();
//            log.info("Consumer3 已消费消息：topic为[{}]-data为[{}]", TOPIC, msg);
//        }
//    }
}