package com.dpim.kafka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author cxw
 */
@MapperScan("com.dpim.kafka.mapper.**")
@ComponentScan({"com.dpim.kafka.**"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }
}
