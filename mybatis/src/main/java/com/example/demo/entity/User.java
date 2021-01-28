package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * user
 *
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
}