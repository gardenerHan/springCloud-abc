package com.hgx.springcloud.payment.controller;

import com.hgx.springcloud.common.entities.response.CommonResultResponse;
import com.hgx.springcloud.payment.entities.Payment;
import com.hgx.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResultResponse<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("返回结果：{}", result);
        if (result > 0) {
            return  new CommonResultResponse<>("200","成功",result);
        } else {
            return new CommonResultResponse<>("500","失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResultResponse<Payment> getPaymentById(@PathVariable("id") Integer id) {
        Payment result = paymentService.getById(id);
        log.info("返回结果  result:{}", result);
        if (result != null) {
            return  new CommonResultResponse<>("200","成功",result);
        } else {
            return new CommonResultResponse<>("500","失败",null);
        }
    }


}
