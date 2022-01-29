package com.dpim.kafka.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dpim.kafka.mapper.UserMapper;
import com.dpim.kafka.model.User;
import com.dpim.kafka.service.UserService;
import com.dpim.kafka.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author cxw
 * @date 2022/1/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 添加用户
     * @param user 用户对象
     * @return int
     * @author cxw
     * @date 2022/1/24
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(User user) {
        return userMapper.insert(user);
    }

    /**
     * 批量添加
     * @param users 用户对象列表
     * @return int
     * @author cxw
     * @date 2022/1/24
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBatch(List<User> users) {
        return userMapper.insertBatch(users);
    }

    /**
     * 插入kafka消息到库
     *
     * @param kafkaMsg 消费的消息
     * @return int
     * @author cxw
     * @date 2022/1/29
     */
    @Override
    public int insertByMsg(Object kafkaMsg) {
        if (kafkaMsg != null) {
            JSONObject obj = JSONObject.parseObject(kafkaMsg.toString());
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
            return insert(user);
        } else {
            return 0;
        }
    }
}
