package com.jh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangfu
 * @date 2019/08/23 15:37
 */
@EnableEurekaServer
@SpringBootApplication
public class SpdEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpdEurekaApplication.class, args);
        System.out.println("Eureka 启动成功！");
    }

}
