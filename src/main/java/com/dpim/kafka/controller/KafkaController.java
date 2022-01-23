package com.dpim.kafka.controller;

import com.dpim.kafka.component.Sender;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author cxw
 * @date 2022/1/19
 */
@Slf4j
@RestController
@RequestMapping("kafka")
public class KafkaController {

      /** 第2种：测试GET请求，模拟数据 */

//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    @GetMapping("/sendMsg")
//    public String sendMsg() throws InterruptedException {
//        for (int i = 0; i < 3; i++) {
//            log.info("---------------第"+(i+1)+"条信息已发送。。。-----------------");
//            kafkaTemplate.send("kafka-test-topic", "test_"+i, "value_"+i*10);
//            Thread.sleep(2000);
//        }
//        return "message send success";
//    }
//
//    @KafkaListener(topics = "kafka-test-topic")
//    public void receive(ConsumerRecord<String, Object> consumer) {
//        log.info("消息已消费：topic为[{}]-key为[{}]-value为[{}]", consumer.topic(), consumer.key(), consumer.value());
//    }

    /** 第3种：测试POST请求，携带数据 */

    @Autowired
    Sender sender;

    @RequestMapping(value = "/sender.action", method = RequestMethod.POST)
    public void exec(HttpServletRequest request, HttpServletResponse response, String data) throws IOException {
        this.sender.send("kafka-test-topic",data);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        response.getWriter().write("success");
        response.getWriter().flush();
        response.getWriter().close();
    }

}
