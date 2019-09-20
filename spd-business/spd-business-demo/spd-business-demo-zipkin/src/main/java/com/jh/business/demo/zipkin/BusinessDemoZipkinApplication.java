package com.jh.business.demo.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
public class BusinessDemoZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessDemoZipkinApplication.class,args);
        System.out.println("Business-Demo-Zipkin 启动成功！");
    }

}
