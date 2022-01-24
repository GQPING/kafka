package com.dpim.kafka.controller;

import com.alibaba.fastjson.JSONObject;
import com.dpim.kafka.model.User;
import com.dpim.kafka.service.UserService;
import com.dpim.kafka.utils.controller.BaseController;
import com.dpim.kafka.utils.domain.AjaxResult;
import com.dpim.kafka.utils.uuid.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author cxw
 * @date 2022/1/19
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /** 模拟接收数据，插入数据库 */
    @KafkaListener(topics = "${spring.kafka.topic.test_group1}")
    public AjaxResult receive(ConsumerRecord<String, Object> consumer) {
        String key = consumer.key();
        Object value = consumer.value();
        String topic = consumer.topic();
        Optional kafkaMsg = Optional.ofNullable(value);
        if (kafkaMsg.isPresent()) {
            log.info("消息已消费：topic为[{}]-key为[{}]-value为[{}]", topic, key, value);
            return insertObj(String.valueOf(kafkaMsg.get()));
        } else {
            log.info("消息未消费：topic为[{}]-key为[{}]-value为[{}]", topic, key, null);
            return AjaxResult.error();
        }
    }

    /**
     * 插入对象
     *
     * @param jsonString json字符串
     * @return void
     * @author cxw
     * @date 2022/1/24
     */
    private AjaxResult insertObj(String jsonString){
        log.info("返回数据：result为[{}]",jsonString);
        JSONObject obj = JSONObject.parseObject(jsonString);
        String id = IdUtils.fastSimpleUUID();
        String name = obj.getString("name");
        String phone = obj.getString("phone");
        String address = obj.getString("address");
        //声明创建用户对象
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);
        return toAjax(userService.insert(user));
    }
}