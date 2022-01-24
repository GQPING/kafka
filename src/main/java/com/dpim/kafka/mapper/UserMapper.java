package com.dpim.kafka.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.dpim.kafka.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cxw
 * @date 2022/1/19
 */
@Mapper
@DS("kafka")
public interface UserMapper {
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

    /**
     * 删除用户
     * @param id 主键
     * @return int
     * @author cxw
     * @date 2022/1/24
     */
    int delete(String id);

    /**
     * 批量删除
     * @param ids 主键数组
     * @return int
     * @author cxw
     * @date 2022/1/24
     */
    int deleteBatch(String[] ids);

    /**
     * 修改用户
     * @param user 用户对象
     * @return int
     * @author cxw
     * @date 2022/1/24
     */
    int update(User user);

    /**
     * 批量修改
     * @param user 用户对象
     * @param ids 主键数组
     * @return int
     * @author cxw
     * @date 2022/1/24
     */
    int updateBatch(@Param("user") User user, @Param("ids") String[] ids);

    /**
     * 查询用户详情
     * @param id 主键
     * @return User
     * @author cxw
     * @date 2022/1/24
     */
    User select(String id);

    /**
     * 批量查询用户
     * @param ids 主键数组
     * @return List<User>
     * @author cxw
     * @date 2022/1/24
     */
    List<User> selectBatch(String[] ids);

    /**
     * 查询用户列表
     * @return List<User>
     * @author cxw
     * @date 2022/1/24
     */
    List<User> selectList();
}
