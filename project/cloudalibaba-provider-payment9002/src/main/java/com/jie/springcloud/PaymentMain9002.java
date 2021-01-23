package com.jie.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: chenxiaojie
 * @date: 2020/12/13
 * @time: 10:53 上午
 * @description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9002 {

    public static void main ( String [] args ) {
        SpringApplication.run(PaymentMain9002.class, args);
    }
}
