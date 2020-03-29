package com.hgx.springcloud.orderfeign.service;

import com.hgx.springcloud.common.entities.response.CommonResultResponse;
import com.hgx.springcloud.orderfeign.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentOpenFeignService {

    @GetMapping("/payment/get/{id}")
    public CommonResultResponse<Payment> getPaymentById(@PathVariable("id") Integer id);
}
