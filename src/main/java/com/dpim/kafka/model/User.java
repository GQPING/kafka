package com.dpim.kafka.model;

import lombok.Data;

/**
 * @author cxw
 * @date 2022/1/19
 */
@Data
public class User {

    /** 用户名 */
    private  String username;

    /** 用户id */
    private String userid;

    /** 用户状态 */
    private String state;

}
