package com.hgx.springcloud.orderribbon;

import com.hgx.springclod.ribbon.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "cloud-order-service-ribbon", configuration = MySelfRule.class)
public class OrderRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderRibbonApplication.class, args);
    }

}
