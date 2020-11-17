package com.jie.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author chenxiaojie
 * @date: 2020/10/18
 * @time: 12:05
 * @description: TODO
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
