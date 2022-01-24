package com.dpim.kafka.service.impl;

import com.dpim.kafka.mapper.UserMapper;
import com.dpim.kafka.model.User;
import com.dpim.kafka.service.UserService;
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
}
