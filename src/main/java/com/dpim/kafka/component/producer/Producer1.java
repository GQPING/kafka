package com.dpim.kafka.component.producer;

import com.alibaba.fastjson.JSONObject;
import com.dpim.kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author cxw
 * @date 2022/1/26
 */
//@Slf4j
//@Component
public class Producer1 {
//    /**
//     * 生产者消息模板
//     */
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
////    @Autowired
////    private KafkaTemplate<String, Object> kafkaTemplate;
////
////    public Producer1(KafkaTemplate<String, String> kafkaTemplate) {
////        this.kafkaTemplate = kafkaTemplate;
////    }
//
////    /**
////     * 并发执行计数器
////     */
////    private CountDownLatch latch = new CountDownLatch(1);
//
//    /**
//     * 定时发送消息到指定主题
//     *
//     * @param topic 消息主题
//     * @return void
//     * @author cxw
//     * @date 2022/1/29
//     */
//    public void sendMsg(String topic) {
//        User user = new User();
//        //user.setName("producer1_" + latch.getCount());
//        user.setPhone("15239948664");
//        user.setAddress("河南省郑州市");
//        String jsonString = JSONObject.toJSONString(user);
//        kafkaTemplate.send(topic, jsonString);
//        log.info("Producer1 已生产消息：topic为[{}]-data为[{}]", topic, jsonString);
//    }
//
//    /**
//     * 批量发送消息到指定主题
//     */
//    public void sendMsg(String topic, List<String> msgList) {
//        msgList.forEach(msg -> kafkaTemplate.send(topic, msg));
//    }
//
//    /**
//     * 请求发送消息到指定主题
//     *
//     * @param topic 消息主题
//     * @param msg   消息内容
//     * @return void
//     * @author cxw
//     * @date 2022/1/29
//     */
//    public void sendMsg(String topic, String msg) {
//        kafkaTemplate.send(topic, msg);
//        log.info("Producer1 已生产消息：topic为[{}]-data为[{}]", topic, msg);
//    }
//
//    /**
//     * 请求发送消息到指定主题、指定key
//     *
//     * @param topic 消息主题
//     * @param key 指定key
//     * @param msg 消息内容
//     * @return void
//     * @author cxw
//     * @date 2022/1/29
//     */
//    public void sendMsg(String topic, String key, String msg) {
//        kafkaTemplate.send(topic,key,msg);
//        log.info("Producer1 已生产消息：topic为[{}]-key为[{}]-data为[{}]", topic, key, msg);
//    }
//
//    /**
//     * 请求发送消息到指定主题、指定分区、指定key
//     *
//     * @param topic 消息主题
//     * @param partition 主题分区
//     * @param key 指定key
//     * @param msg 消息内容
//     * @return void
//     * @author cxw
//     * @date 2022/1/29
//     */
//    public void sendMsg(String topic, Integer partition, String key, String msg) {
//        kafkaTemplate.send(topic,partition,key,msg);
//        log.info("Producer1 已生产消息：topic为[{}]-partition为[{}]-key为[{}]-data为[{}]", topic, partition, key, msg);
//    }
//
//    /**
//     * 请求发送消息到指定主题、指定分区、指定时间戳、指定key
//     *
//     * @param topic 消息主题
//     * @param partition 主题分区
//     * @param timestamp 时间戳
//     * @param key 指定key
//     * @param msg 消息内容
//     * @return void
//     * @author cxw
//     * @date 2022/1/29
//     */
//    public void sendMsg(String topic, Integer partition, Long timestamp, String key, String msg) {
//        kafkaTemplate.send(topic,partition,timestamp,key,msg);
//        log.info("Producer1 已生产消息：topic为[{}]-partition为[{}]-timestamp为[{}]-key为[{}]-data为[{}]", topic, partition, timestamp, key, msg);
//    }
}
