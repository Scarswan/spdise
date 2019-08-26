package com.jh.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author yangfu
 * @data 2019/08/23 15:37
 */
@EnableEurekaServer
@SpringBootApplication
public class SpdEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpdEurekaApplication.class, args);
    }

}
