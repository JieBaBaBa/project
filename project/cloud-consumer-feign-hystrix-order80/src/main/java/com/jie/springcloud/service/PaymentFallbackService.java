package com.jie.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author chenxiaojie
 * @date: 2020/10/25
 * @time: 11:03
 * @description:
 *  超时的话这里也可以接，所以controller无需写@HystrixCommand，完成解耦
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService paymentInfo_OK 出错了";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService paymentInfo_TimeOut 出错了";
    }
}
