package com.hgx.springcloud.orderfeign.controller;

import com.hgx.springcloud.common.entities.response.CommonResultResponse;
import com.hgx.springcloud.orderfeign.entities.Payment;
import com.hgx.springcloud.orderfeign.service.PaymentOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResultResponse<Payment> get(@PathVariable("id") Integer id) {

        CommonResultResponse<Payment> res = paymentOpenFeignService.getPaymentById(id);
        log.info("返回结果：{}",res);
        return res;
    }


}
