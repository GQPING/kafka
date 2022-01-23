package com.dpim.kafka;

import com.dpim.kafka.component.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

//@MapperScan("com.dpim.kafka.mapper.**")
@ComponentScan({"com.dpim.kafka.**"})
@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

//    /** 第1种：本地程序启动后测试kafka是否正常 */
//    @Autowired
//    private Producer producer;
//
//    /**
//     * 连续10个消息
//     */
//    @PostConstruct
//    public void init() {
//        for (int i = 0; i < 3; i++) {
//            producer.sendMsg(String.valueOf(i));
//        }
//    }

}
