package com.jie.springcloud.service.impl;

import com.jie.springcloud.dao.PaymentDao;
import com.jie.springcloud.entities.Payment;
import com.jie.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author chenxiaojie
 * @date: 2020/9/12
 * @time: 13:06
 * @description: TODO
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
}
