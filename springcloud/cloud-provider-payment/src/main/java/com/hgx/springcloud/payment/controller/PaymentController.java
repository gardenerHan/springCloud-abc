package com.hgx.springcloud.payment.controller;

import com.hgx.springcloud.common.entities.response.CommonResultResponse;
import com.hgx.springcloud.payment.entities.Payment;
import com.hgx.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery() {

        List<String> services = discoveryClient.getServices();
        for (String server :
                services) {
            System.out.println(server);
            List<ServiceInstance> instances = discoveryClient.getInstances(server);
            for (ServiceInstance instance :
                    instances) {
                System.out.println(instance.getServiceId() + "\t" + instance.getInstanceId() + "\t"
                        + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            }


        }

        return discoveryClient;
    }


}
