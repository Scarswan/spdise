package com.jh.business.demo.zipkin;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;
import zipkin2.server.internal.RegisterZipkinHealthIndicators;

@EnableEurekaClient
@EnableZipkinServer
@SpringBootApplication
public class BusinessDemoZipkinApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(BusinessDemoZipkinApplication.class)
                .listeners(new RegisterZipkinHealthIndicators()).run(args);
    }

}
