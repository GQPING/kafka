package com.dpim.kafka.component.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

/**
 * @author cxw
 * @date 2022/1/26
 */
@Slf4j
@Component
public class Consumer1 {
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
    @KafkaListener(id="consumer1-1",topics = "${spring.kafka.topic.test_group1}")
    public void consumer(ConsumerRecord consumerRecord) {
        try {
            Optional kafkaMsg = Optional.ofNullable(consumerRecord.value());
            if (kafkaMsg.isPresent()) {
                latch.countDown();
                Object msg = kafkaMsg.get();
                log.info("Consumer1 已消费消息：topic为[{}]-data为[{}]", TOPIC, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    /**
//     * 监听topic1主题,单条消费
//     */
//    @KafkaListener(topics = "topic1")
//    public void listen0(ConsumerRecord<String, String> record) {
//        consumer(record);
//    }
//
//    /**
//     * 监听topic2主题,单条消费
//     */
//    @KafkaListener(topics = "${topicName.topic2}")
//    public void listen1(ConsumerRecord<String, String> record) {
//        consumer(record);
//    }
//
//    /**
//     * 监听topic3和topic4,单条消费
//     */
//    @KafkaListener(topics = {"topic3", "topic4"})
//    public void listen2(ConsumerRecord<String, String> record) {
//        consumer(record);
//    }
//
//    /**
//     * 监听topic5,批量消费
//     */
//    @KafkaListener(topics = "${topicName.topic2}", containerFactory = "batchFactory")
//    public void listen2(List<ConsumerRecord<String, String>> records) {
//        batchConsumer(records);
//    }
//
//    /**
//     * 单条消费
//     */
//    public void consumer(ConsumerRecord<String, String> record) {
//        log.info("主题:{}, 内容: {}", record.topic(), record.value());
//    }
//
//    /**
//     * 批量消费
//     */
//    public void batchConsumer(List<ConsumerRecord<String, String>> records) {
//        records.forEach(record -> consumer(record));
//    }

//    /**
//     * 消费一个消息
//     */
//    @KafkaListener(id="consumer1-2",topics = "${spring.kafka.topic.test_group1}")
//    public void consumer(ConsumerRecord<String, String> consumerRecord) {
//        try {
//            Optional<?> kafkaMsg = Optional.ofNullable(consumerRecord.value());
//            if (kafkaMsg.isPresent()) {
//                latch.countDown();
//                Object msg = kafkaMsg.get();
//                log.info("Consumer1 已消费消息：topic为[{}]-data为[{}]", TOPIC, msg);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    /**
//     * 消费一个消息, 指定主题，手动提交
//     */
//    @KafkaListener(id="consumer1-3", topics = "${spring.kafka.topic.test_group1}", containerFactory = "kafkaListenerContainerFactory")
//    public void consumerTopic(ConsumerRecord consumerRecord, Acknowledgment ack) {
//        try {
//            Optional kafkaMsg = Optional.ofNullable(consumerRecord.value());
//            if (kafkaMsg.isPresent()) {
//                latch.countDown();
//                Object msg = kafkaMsg.get();
//                log.info("Consumer1 已消费消息：topic为[{}]-data为[{}]", TOPIC, msg);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            //手动提交偏移量
//            ack.acknowledge();
//        }
//    }

//    /**
//     * 消费一个消息, 指定主题和分区，手动提交
//     */
//    @KafkaListener(id="consumer1-4", containerFactory = "kafkaListenerContainerFactory",topicPartitions = {@TopicPartition(topic = "kafka-test-topic",partitions = {"0"})})
//    public void consumerTopicPartitions(ConsumerRecord consumerRecord, Acknowledgment ack) {
//        try {
//            Optional kafkaMsg = Optional.ofNullable(consumerRecord.value());
//            if (kafkaMsg.isPresent()) {
//                latch.countDown();
//                Object msg = kafkaMsg.get();
//                log.info("Consumer1 已消费消息：topic为[{}]-data为[{}]", TOPIC, msg);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //手动提交偏移量
//            ack.acknowledge();
//        }
//    }

//    /**
//     * 批量消费消息，手动提交
//     */
//    @KafkaListener(id="consumer1-5", topics = "${spring.kafka.topic.test_group1}", containerFactory = "kafkaListenerContainerFactory")
//    public void consumerBatch(List<ConsumerRecord> records, Acknowledgment ack) {
//        try {
//            for (ConsumerRecord record : records) {
//                Optional kafkaMsg = Optional.ofNullable(record.value());
//                if (kafkaMsg.isPresent()) {
//                    latch.countDown();
//                    Object msg = kafkaMsg.get();
//                    log.info("Consumer1 已消费消息：topic为[{}]-data为[{}]", TOPIC, msg);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //手动提交偏移量
//            ack.acknowledge();
//        }
//    }
}
