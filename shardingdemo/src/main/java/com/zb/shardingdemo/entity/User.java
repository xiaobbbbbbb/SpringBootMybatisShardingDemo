package com.zb.shardingdemo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Long id;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 年龄
     */
    private Byte age;

    private static final long serialVersionUID = 1L;

    public User(){

    }

    public User(Long id,String userName,Byte age){
        this.id=id;
        this.userName=userName;
        this.age=age;
    }

}