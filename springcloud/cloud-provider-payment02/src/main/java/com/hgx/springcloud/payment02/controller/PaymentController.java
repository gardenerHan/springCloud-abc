package com.hgx.springcloud.payment02.controller;

import com.hgx.springcloud.common.entities.response.CommonResultResponse;
import com.hgx.springcloud.payment02.entities.Payment;
import com.hgx.springcloud.payment02.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResultResponse<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("返回结果：{}", result);
        if (result > 0) {
            return new CommonResultResponse<>("200", "成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResultResponse<>("500", "失败,serverPort" + serverPort, null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResultResponse<Payment> getPaymentById(@PathVariable("id") Integer id) {
        Payment result = paymentService.getById(id);
        log.info("返回结果  result:{}", result);
        if (result != null) {
            return new CommonResultResponse<>("200", "成功,serverPort:" + serverPort, result);
        } else {
            return new CommonResultResponse<>("500", "失败,serverPort:" + serverPort, null);
        }
    }
}
