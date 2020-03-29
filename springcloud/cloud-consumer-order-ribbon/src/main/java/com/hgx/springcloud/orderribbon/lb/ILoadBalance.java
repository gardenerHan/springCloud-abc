package com.hgx.springcloud.orderribbon.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBalance {

    ServiceInstance instance(List<ServiceInstance> serviceInstances) ;

}
