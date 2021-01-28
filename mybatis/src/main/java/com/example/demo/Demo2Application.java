package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//添加扫描mybatis的dao层接口，生成实现类
@MapperScan(value = "com.example.demo.mapper")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class Demo2Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}
