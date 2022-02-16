package com.dpim.kafka.controller;

import com.alibaba.fastjson.JSONObject;
import com.dpim.kafka.component.producer.Producer1;
import com.dpim.kafka.model.User;
import com.dpim.kafka.utils.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Set;

/**
 * kafka消息控制器
 *
 * @author cxw
 * @date 2022/1/19
 */
@Slf4j
@RestController
@RequestMapping("kafka")
public class KafkaController extends BaseController {

//    @Autowired
//    private Producer1 sender;

    @Autowired
    private KafkaTemplate sender;

//    @Autowired
//    private AdminClient adminClient;

    /**
     * 测试主题
     */
    private static String TOPIC = "kafka-test-topic";

    /**
     * 测试POST请求，携带数据
     */
    @RequestMapping(value = "/sender.action", method = RequestMethod.POST)
    public void execMsg(HttpServletResponse response, String data) {
        try {
            //模拟json数据
            User user = new User();
            user.setName("请求消息测试");
            user.setPhone("15239948664");
            user.setAddress("河南省郑州市");
            String jsonString = JSONObject.toJSONString(user);

            data = jsonString;

            sender.send(TOPIC, data);

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/json");
            response.getWriter().write("message send success");
            response.getWriter().flush();
            response.getWriter().close();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("测试消息发生异常：topic为[{}]-data为[{}]", TOPIC, data);
        }
    }

//    /**
//     * 创建topic和分区
//     *
//     * @return void
//     * @author cxw
//     * @date 2022/1/29
//     */
//    @RequestMapping(value = "/addTopic", method = RequestMethod.GET)
//    public void createTopic(@RequestParam("topicName") String topicName, @RequestParam("partitions") Integer partitions, @RequestParam("replication") Short replication) {
//        try {
//            // 这种是手动创建topic
//            // 注意分区数量只能增加不能减少
//            // 如果topic的名字相同，那么会覆盖以前的那个
//            // 分区多的好处是能快速的处理并发量，但是也要根据机器的配置
//            log.info("成功创建主题：topic为[{}]-partitions[{}]-replication为[{}]",  topicName, partitions, replication);
//            NewTopic topic = new NewTopic(topicName, partitions, replication);
//            adminClient.createTopics(Arrays.asList(topic));
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.info("创建主题异常：topic为[{}]-partitions[{}]-replication为[{}]", topicName, partitions, replication);
//        }
//    }
//
//    /**
//     * 获取所有的topic信息
//     *
//     * @return void
//     * @author cxw
//     * @date 2022/1/29
//     */
//    @RequestMapping(value = "/getTopics", method = RequestMethod.GET)
//    public void getAllTopic() {
//        try {
//            ListTopicsResult listTopics = adminClient.listTopics();
//            Set<String> topics = listTopics.names().get();
//            for (String topic : topics) {
//                System.err.println(topic);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
