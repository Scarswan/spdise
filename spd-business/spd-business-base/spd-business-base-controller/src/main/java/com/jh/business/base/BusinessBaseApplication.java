package com.jh.business.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"com.jh.api"})
@ComponentScans(value = {@ComponentScan(value = "com.jh.business.base"),@ComponentScan(value = "com.jh.api")})
@MapperScan("com.jh.business.base.mapper")
public class BusinessBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessBaseApplication.class, args);
        System.out.println("Business-Base 启动成功！");
    }

}
