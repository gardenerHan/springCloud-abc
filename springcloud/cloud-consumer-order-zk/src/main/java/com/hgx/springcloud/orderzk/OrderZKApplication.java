package com.hgx.springcloud.orderzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderZKApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKApplication.class, args);
    }

}
