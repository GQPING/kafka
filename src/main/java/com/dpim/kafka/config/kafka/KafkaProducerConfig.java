package com.dpim.kafka.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * 生产者
 * 参数配置类，其参数卸载yml文件中，通过@Value注入
 *
 * @author cxw
 * @date 2022/1/20
 */
@Slf4j
@EnableKafka
@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

//    @Value("${spring.kafka.producer.linger}")
//    private Integer linger;
//
//    @Value("${spring.kafka.producer.retries}")
//    private Integer retries;
//
//    @Value("${spring.kafka.producer.batch-size}")
//    private Integer batchSize;
//
//    @Value("${spring.kafka.producer.buffer-memory}")
//    private Integer bufferMemory;

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        //配置Kafka实例的连接地址
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

//        //设置重试次数
//        props.put(ProducerConfig.RETRIES_CONFIG, retries);
//        //达到batchSize大小的时候会发送消息
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
//        //延时时间，延时时间到达之后计算批量发送的大小没达到也发送消息
//        props.put(ProducerConfig.LINGER_MS_CONFIG, linger);
//        //缓冲区的值
//        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);

        //序列化手段
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        //producer端的消息确认机制,-1和all都表示消息不仅要写入本地的leader中还要写入对应的副本中
        //如果是单个broker,推荐使用'1'
        props.put(ProducerConfig.ACKS_CONFIG, "1");

//        //单条消息的最大值以字节为单位,默认值为1048576
//        props.put(ProducerConfig.LINGER_MS_CONFIG, 10485760);
//        //设置broker响应时间，如果broker在60秒之内还是没有返回给producer确认消息，则认为发送失败
//        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 60000);
//        //设置压缩算法(默认是木有压缩算法的)
//        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");//snappy

        //指定拦截器(value为对应的class)
        //props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, "com.te.handler.KafkaProducerInterceptor");

        return props;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }
}
