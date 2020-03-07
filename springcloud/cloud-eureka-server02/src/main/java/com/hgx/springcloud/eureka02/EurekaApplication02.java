package com.hgx.springcloud.eureka02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication02.class, args);
    }
}
