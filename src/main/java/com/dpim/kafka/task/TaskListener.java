package com.dpim.kafka.task;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * KafkaListener定时启动和停止
 * @author cxw
 * @date 2022/1/29
 */
@Slf4j
@Component
@EnableScheduling
public class TaskListener {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    /**
     * 批量消费消息
     *
     * @param records 消息列表
     * @param ack 确认代理
     * @return void
     * @author cxw
     * @date 2022/1/29
     */
//    @KafkaListener(id = "test0", topics = "kafka-test-topic", containerFactory = "kafkaListenerContainerFactory")
//    public void consumerMsg(List<ConsumerRecord> records, Acknowledgment ack) {
//        try {
//            for (ConsumerRecord record : records) {
//                //这里做数据持久化的操作
//                log.info("kafka-test-topic receive : " + String.format("offset = %d, key = %s, value = %s%n \n", record.offset(), record.key(), record.value()));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //手动提交偏移量
//            ack.acknowledge();
//        }
//    }

    /**
     * 定时器，每天凌晨0点开启监听
     *
     * @return void
     * @author cxw
     * @date 2022/1/29
     */
//    @Scheduled(cron = "0 0 0 * * ?")
//    public void startListener() {
//        log.info("开启监听");
//        //判断监听容器是否启动，未启动则将其启动
//        if (!registry.getListenerContainer("test0").isRunning()) {
//            registry.getListenerContainer("test0").start();
//        }
//        registry.getListenerContainer("test0").resume();
//    }

    /**
     * 定时器，每天早上10点关闭监听
     *
     * @return void
     * @author cxw
     * @date 2022/1/29
     */
//    @Scheduled(cron = "0 0 10 * * ?")
//    public void shutDownListener() {
//        log.info("关闭监听");
//        registry.getListenerContainer("test0").pause();
//    }
}
