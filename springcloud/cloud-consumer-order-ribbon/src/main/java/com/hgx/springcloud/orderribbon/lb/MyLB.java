package com.hgx.springcloud.orderribbon.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 参考RoundRobinRule
 */
@Component
public class MyLB implements ILoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取访问次数
     * @return 访问次数
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next)) ;
        System.out.println("---访问次数："+next);
        return next ;
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        //求余获取下标
        int index = getAndIncrement() % serviceInstances.size() ;
        return serviceInstances.get(index);
    }
}
