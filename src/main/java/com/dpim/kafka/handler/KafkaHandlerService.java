package com.dpim.kafka.handler;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * KafkaListener通过配置加载多个topic
 *
 * @author cxw
 * @date 2022/1/29
 */
@Service
public class KafkaHandlerService {
//    @Autowired
//    private Environment env;

    /**
     *利用反射配置多个topics
     *
     * @param
     * @return void
     * @author cxw
     * @date 2022/1/29
     */
    @PostConstruct
    public void initKafkaHandler() {
        try {
            //比如topics是    topic1,topic2
            //String topics = env.getProperty("xxx.xxx");
            String topics = "";
            String[] topicArray = topics.split(",");

            //反射，listen是方法名，ConsumerRecord.class是参数的类，找到这个监听方法修改topics的值
            Method listen = KafkaHandlerService.class.getDeclaredMethod("listen", ConsumerRecord.class);
            KafkaListener kafkaListener = listen.getAnnotation(KafkaListener.class);
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(kafkaListener);
            Field hField = invocationHandler.getClass().getDeclaredField("memberValues");

            //默认的访问权限是不行的，要修改成true才能修改属性的值
            hField.setAccessible(true);
            Map memberValues = (Map) hField.get(invocationHandler);

            memberValues.put("topics", topicArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    //topics属性都不用设置了，因为已经通过反射设置好了
//    @KafkaListener
//    public void listen(ConsumerRecord<?, ?> record) {
//        //为所欲为
//    }
}
