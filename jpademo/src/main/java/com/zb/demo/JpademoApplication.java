package com.zb.demo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.zb.demo",includeFilters = {@ComponentScan.Filter(Aspect.class)})
@EntityScan(basePackages = "com.zb.demo.entity")
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

}
