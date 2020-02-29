package com.zlf.open.api.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 */
@Data
public class User implements Serializable {

    //用户ID
    private Integer id;

    //用户名
    private String username;

    //用户密码
    private String password;

}
