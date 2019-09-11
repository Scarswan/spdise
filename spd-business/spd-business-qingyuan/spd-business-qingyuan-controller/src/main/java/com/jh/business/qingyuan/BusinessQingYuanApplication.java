package com.jh.business.qingyuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableEurekaClient
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jh.business.qingyuan.mapper")
public class BusinessQingYuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessQingYuanApplication.class, args);
        System.out.println("Business-QingYuan 启动成功！");
    }

}
