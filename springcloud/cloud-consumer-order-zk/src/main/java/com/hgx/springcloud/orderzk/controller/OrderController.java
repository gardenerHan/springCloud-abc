package com.hgx.springcloud.orderzk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate ;

//    private String url = "http://localhost:8001" ;
private String url = "http://cloud-payment-service-zk" ;


    @GetMapping("/consumer/payment/get/zk")
    public Object get(){
        return restTemplate.getForObject(url+"/payment/zk/discovery", Object.class);
    }

}
