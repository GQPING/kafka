package com.dpim.kafka.task;

import com.dpim.kafka.component.producer.Producer1;
import com.dpim.kafka.component.producer.Producer2;
import com.dpim.kafka.component.producer.Producer3;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 生产者定时器
 * @author cxw
 * @date 2022/1/29
 */
@Slf4j
@Configuration
@EnableScheduling
public class RyTask {

    @Autowired
    private Producer1 producer1;

    @Autowired
    private Producer2 producer2;

    @Autowired
    private Producer3 producer3;

    /** 生产到指定主题 */
    private static final String TOPIC = "kafka-test-topic";

    /** 定时产生一个消息 每1分钟执行一次 */
//    @Scheduled(cron = "0 */1 * * * ?")
//    public void producer1Task() {
//        log.info("=========== Producer1 生产定时任务开始了 ===========");
//        producer1.sendMsg(TOPIC);
//        log.info("=========== Producer1 生产定时任务结束了 ===========");
//    }

    /** 定时产生一个消息 每2分钟执行一次 */
//    @Scheduled(cron = "0 */2 * * * ?")
//    public void producer2Task() {
//        log.info("=========== Producer2 生产定时任务开始了 ===========");
//        producer2.sendMsg(TOPIC);
//        log.info("=========== Producer2 生产定时任务结束了 ===========");
//    }

    /** 定时产生一个消息 每3分钟执行一次 */
//    @Scheduled(cron = "0 */3 * * * ?")
//    public void producer3Task() {
//        log.info("=========== Producer3 生产定时任务开始了 ===========");
//        producer3.sendMsg(TOPIC);
//        log.info("=========== Producer3 生产定时任务结束了 ===========");
//    }
}
