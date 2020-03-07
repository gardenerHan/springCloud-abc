package com.hgx.springcloud.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hgx.springcloud.order.entities.Payment;
import com.hgx.springcloud.common.entities.response.CommonResultResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate ;

    @PostMapping("/consumer/payment/create")
    public CommonResultResponse create(@RequestBody  Payment payment){
        CommonResultResponse<Integer> res = restTemplate.postForObject("http://localhost:8001/payment/create", payment, CommonResultResponse.class);
        Integer data = res.getData();
        System.out.println(data);
        return res;
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResultResponse<Payment> get(@PathVariable("id") Integer id){
        CommonResultResponse<Payment> res = restTemplate.getForObject("http://localhost:8001/payment/get/"+id, CommonResultResponse.class);

        Payment data = new ObjectMapper().convertValue(res.getData(),Payment.class);

        return res ;
    }

}
