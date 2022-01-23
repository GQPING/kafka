package com.dpim.kafka.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息发送类
 * @author cxw
 * @date 2022/1/20
 */
@Slf4j
@Component
public class Sender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String topic,String payload) {
        log.info("sending payload='{}' to topic='{}'",payload,topic);
        this.kafkaTemplate.send(topic,payload);
    }

}
