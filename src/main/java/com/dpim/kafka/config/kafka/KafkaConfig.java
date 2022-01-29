package com.dpim.kafka.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;
import java.util.HashMap;
import java.util.Map;

/**
 * kafka客户端
 * 参数配置类，其参数卸载yml文件中，通过@Value注入
 *
 * @author cxw
 * @date 2022/1/29
 */
@Slf4j
@EnableKafka
@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /**
     * kafka管理类相关配置
     *
     * @param
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author cxw
     * @date 2022/1/29
     */
    @Bean
    public Map<String, Object> adminConfigs() {
        Map<String, Object> props = new HashMap<>();
        //配置Kafka实例的连接地址
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        return props;
    }

    /**
     * 创建一个kafka管理类，没有此bean无法自定义的使用adminClient创建topic
     *
     * @param
     * @return org.springframework.kafka.core.KafkaAdmin
     * @author cxw
     * @date 2022/1/29
     */
    @Bean
    public KafkaAdmin adminFactory() {
        return new KafkaAdmin(adminConfigs());
    }

    /**
     * kafka客户端，在spring中创建这个bean之后可以注入并且创建topic,用于集群环境，创建对个副本
     *
     * @return org.apache.kafka.clients.admin.AdminClient
     * @author cxw
     * @date 2022/1/29
     */
    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(adminFactory().getConfigurationProperties());
    }
}
