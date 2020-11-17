package com.jie.springcloud.service;

import com.jie.springcloud.entities.Payment;

import java.util.List;

/**
 * @author chenxiaojie
 * @date: 2020/9/12
 * @time: 13:06
 * @description: TODO
 */
public interface PaymentService {

    Payment getById(Long id);

    int create(Payment payment);
}
