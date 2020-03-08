package com.hgx.springcloud.payment02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PaymentApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication02.class, args);
    }
}
