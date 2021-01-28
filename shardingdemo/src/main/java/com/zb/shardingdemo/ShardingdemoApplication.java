package com.zb.shardingdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.zb")
@EnableAutoConfiguration(exclude = JtaAutoConfiguration.class)//排除spring框架的数据源，使用sharding数据源配置
//添加扫描mybatis的dao层接口，生成实现类
@MapperScan(value = "com.zb.shardingdemo.mapper")
public class ShardingdemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ShardingdemoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ShardingdemoApplication.class, args);
	}

}
