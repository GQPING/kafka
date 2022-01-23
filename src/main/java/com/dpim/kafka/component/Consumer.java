package com.dpim.kafka.component;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * 第1种：本地程序启动后测试kafka是否正常
 * @author cxw
 * @date 2022/1/19
 */
@Component
public class Consumer {

//    /** 消费一个消息 */
//    @KafkaListener(topics = {"kafka-test-topic"})
//    public void consumer(ConsumerRecord consumerRecord){
//        Optional kafkaMsg = Optional.ofNullable(consumerRecord.value());
//        if (kafkaMsg.isPresent()){
//            Object msg = kafkaMsg.get();
//            System.err.println(msg);
//        }
//    }

}
