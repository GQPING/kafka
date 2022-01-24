package com.dpim.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * 消息接受类
 * @author cxw
 * @date 2022/1/20
 */
@Slf4j
@Component
public class Receiver {

//    private CountDownLatch latch = new CountDownLatch(1);
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//    @KafkaListener(topics = "${spring.kafka.topic.test_group1}")
//    public void receive(String payload) {
//        log.info("received payload='{}'",payload);
//        latch.countDown();
//    }

}
