package com.jie.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenxiaojie
 * @date: 2020/10/18
 * @time: 12:06
 * @description: TODO
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);

    /**
     * 源码
     *
     * @param modulo
     * @return
     */
    private int incrementAndGetModulo(int modulo) {
        int current;
        int next;
        do {
            current = this.nextServerCyclicCounter.get();
            next = (current + 1) % modulo;
        } while(!this.nextServerCyclicCounter.compareAndSet(current, next));

        return next;
    }

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.nextServerCyclicCounter.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
        } while (!nextServerCyclicCounter.compareAndSet(current, next));
        System.out.println("-------------------第几次访问，次数next--->" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
