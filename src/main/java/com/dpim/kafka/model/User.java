package com.dpim.kafka.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author cxw
 * @date 2022/1/19
 */
@Data
public class User {

    /** 主键 */
    private String id;

    /** 名称 */
    private String name;

    /** 电话 */
    private String phone;

    /** 地址 */
    private String address;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

}
