package com.dpim.kafka.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Service;

/**
 * kafka的回调类
 * 可以在此类中定义producer发送消息失败时候的回调方法
 * @author cxw
 * @date 2022/1/29
 */
//@Slf4j
//@Service
public class KafkaSendResultHandler implements ProducerListener {
//    @Override
//    public void onSuccess(String topic, Integer partition, Object key, Object value, RecordMetadata recordMetadata) {
//        // TODO Auto-generated method stub
//        log.info("消息发送成功");
//    }
//
//    @Override
//    public void onError(String topic, Integer partition, Object key, Object value, Exception exception) {
//        // TODO Auto-generated method stub
//        //可重试
//        System.out.println("消息发送失败");
//
//    }
//
//    @Override
//    public boolean isInterestedInSuccess() {
//        // TODO Auto-generated method stub
//        return false;
//    }
}
