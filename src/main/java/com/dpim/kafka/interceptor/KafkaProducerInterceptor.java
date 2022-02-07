package com.dpim.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * 生产者拦截器
 *
 * @author cxw
 * @date 2022/1/29
 */
public class KafkaProducerInterceptor implements ProducerInterceptor<String, String> {

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        /**
         * 可以在此方法中定义对消息做一些特殊处理
         */
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        /**
         * 该方法会在消息被应答之前或消息发送失败的时候调用，也可以在此做重试操作
         */
        recordMetadata.partition();
        recordMetadata.topic();
        recordMetadata.serializedKeySize();
        recordMetadata.serializedValueSize();
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
