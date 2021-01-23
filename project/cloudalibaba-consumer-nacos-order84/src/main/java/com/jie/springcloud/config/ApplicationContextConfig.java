package com.jie.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenxiaojie
 * @date: 2020/10/9
 * @time: 12:11
 * @description: TODO
 */
@Configuration
public class ApplicationContextConfig {

    //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力, 本地写的轮询算法不需要该注解，默认的集中轮询算法需要
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    // 给其他地方用就要依赖注入，<bean ..>
}
