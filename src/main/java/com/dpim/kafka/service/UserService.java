package com.dpim.kafka.service;

import com.dpim.kafka.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cxw
 * @date 2022/1/19
 */
public interface UserService {
    /**
     * 添加用户
     * @param user 用户对象
     * @return int
     * @author cxw
     * @date 2022/1/24
     */
    int insert(User user);

    /**
     * 批量添加
     * @param users 用户对象列表
     * @return int
     * @author cxw
     * @date 2022/1/24
     */
    int insertBatch(List<User> users);
}
