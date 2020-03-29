package com.hgx.springcloud.orderribbon.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgx.springcloud.common.entities.response.CommonResultResponse;
import com.hgx.springcloud.orderribbon.entities.Payment;
import com.hgx.springcloud.orderribbon.lb.ILoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate ;
    @Autowired
    private DiscoveryClient discoveryClient ;
    @Resource
    private ILoadBalance loadBalance ;


    //    private String url = "http://localhost:8001" ;
private String url = "http://CLOUD-PAYMENT-SERVICE" ;

    @PostMapping("/consumer/payment/create")
    public CommonResultResponse create(@RequestBody  Payment payment){
        CommonResultResponse<Integer> res = restTemplate.postForObject(url+"/payment/create", payment, CommonResultResponse.class);
        Integer data = res.getData();
        System.out.println(data);
        return res;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResultResponse<Payment> get(@PathVariable("id") Integer id){
        CommonResultResponse<Payment> res = restTemplate.getForObject(url+"/payment/get/"+id, CommonResultResponse.class);

        Payment data = new ObjectMapper().convertValue(res.getData(),Payment.class);

        return res ;
    }


    @GetMapping("/consumer/payment/myLB/get/{id}")
    public CommonResultResponse<Payment> getByMyLB(@PathVariable("id") Integer id){


        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance instance = loadBalance.instance(instances);
        CommonResultResponse<Payment> res = restTemplate.getForObject(instance.getUri()+"/payment/get/"+id, CommonResultResponse.class);

        Payment data = new ObjectMapper().convertValue(res.getData(),Payment.class);

        return res ;
    }









}
