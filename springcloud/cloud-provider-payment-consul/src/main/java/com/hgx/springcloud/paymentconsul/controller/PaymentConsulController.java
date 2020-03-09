package com.hgx.springcloud.paymentconsul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentConsulController {

    @Autowired
    private DiscoveryClient discoveryClient ;


    @GetMapping("/payment/consul/discovery")
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
