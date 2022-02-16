package com.dpim.kafka.component.producer;

import com.alibaba.fastjson.JSONObject;
import com.dpim.kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author cxw
 * @date 2022/1/26
 */
//@Slf4j
//@Component
public class Producer2 {
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
//    /**
//     * 并发执行计数器
//     */
//    private CountDownLatch latch = new CountDownLatch(1);
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
//        user.setName("producer2_" + latch.getCount());
//        user.setPhone("15649865121");
//        user.setAddress("河南省商丘市");
//        String jsonString = JSONObject.toJSONString(user);
//        kafkaTemplate.send(topic, jsonString);
//        //log.info("Producer2 已生产消息：topic为[{}]-data为[{}]", topic, jsonString);
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
//        //log.info("Producer2 已生产消息：topic为[{}]-data为[{}]", topic, msg);
//    }
}
