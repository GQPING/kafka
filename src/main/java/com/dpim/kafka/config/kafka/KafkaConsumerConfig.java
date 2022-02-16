//package com.dpim.kafka.config.kafka;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.ContainerProperties;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 消费者
// * 参数配置类，其参数卸载yml文件中，通过@Value注入
// *
// * @author cxw
// * @date 2022/1/20
// */
//@Slf4j
//@EnableKafka
//@Configuration
//public class KafkaConsumerConfig {
//
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServers;
//
////    @Value("${spring.kafka.consumer.group-id}")
////    private String groupId;
////
////    @Value("${spring.kafka.consumer.enable-auto-commit}")
////    private Boolean autoCommit;
////
////    @Value("${spring.kafka.consumer.auto-offset-reset}")
////    private String autoOffsetReset;
////
////    @Value("${spring.kafka.consumer.max-poll-records}")
////    private Integer maxPollRecords;
//
////    @Value("${kafka.consumer.session.timeout}")
////    private String sessionTimeout;
////
////    @Value("${kafka.consumer.auto.commit.interval}")
////    private String autoCommitInterval;
//
//    /**
//     * 消费者配置
//     * @return
//     */
//    @Bean
//    public Map<String, Object> consumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        //配置Kafka实例的连接地址
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//
//        //序列化手段
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//
//        //消费者组ID
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "kafka_test_group");
//
////        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
////        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
////        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
////        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 180000);
////        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, 900000);
////        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 900000);
//
//        return props;
//    }
//
//    /**
//     * 消费者工厂
//     * @return
//     */
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
//    }
//
//    /**
//     * 监听容器工厂
//     * @return
//     */
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        //并发批量消费者监听工厂
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        //配置消费者工厂
//        factory.setConsumerFactory(consumerFactory());
//
//        //批量消费
//        //每个批次数量在Kafka配置参数中设置ConsumerConfig.MAX_POLL_RECORDS_CONFIG
//        //factory.setBatchListener(true);
//
//        //容器线程数
//        //小于或等于Topic的分区数
//        //factory.setConcurrency(5);
//
//        //设置提交偏移量的方式
//        //MANUAL ： listener负责ack，但是背后也是批量上去
//        //MANUAL_IMMEDIATE ： listner负责ack，每调用一次，就立即commit
//        //factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
//
//        //禁止自动启动
//        //factory.setAutoStartup(false);
//
//        //设置消费者拉取消息超时时间
//        //factory.getContainerProperties().setPollTimeout(3000);
//
//        return factory;
//    }
//}
