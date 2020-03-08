package com.hgx.springcloud.paymentzk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentApplicationZK {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplicationZK.class, args);
    }
}
