package com.dpim.kafka.component;

import com.alibaba.fastjson.JSON;
import com.dpim.kafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * 第1种：本地程序启动后测试kafka是否正常
 * @author cxw
 * @date 2022/1/19
 */
@Component
public class Producer {

//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    /** 产生一个消息 */
//    public void sendMsg(String userid){
//        User user = new User();
//        user.setUsername("cxw");
//        user.setState("1");
//        user.setUserid(userid);
//
//        kafkaTemplate.send("kafka-test-topic", JSON.toJSONString(user));
//    }

}
