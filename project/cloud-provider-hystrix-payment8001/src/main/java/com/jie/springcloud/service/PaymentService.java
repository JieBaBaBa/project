package com.jie.springcloud.service;

import java.util.concurrent.TimeUnit;

/**
 * @author chenxiaojie
 * @date: 2020/10/24
 * @time: 14:50
 * @description: TODO
 */
public interface PaymentService {

    /**
     * 成功
     *
     * @param id
     * @return
     */
    String paymentInfo_OK(Integer id);

    /**
     * 失败
     *
     * @param id
     * @return
     */
    String paymentInfo_TimeOut(Integer id);

    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    String paymentCircuitBreaker(Integer id);
}
