package com.jie.springcloud.service.impl;

import com.jie.springcloud.entities.CommonResult;
import com.jie.springcloud.entities.Payment;
import com.jie.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author: chenxiaojie
 * @date: 2021/1/11
 * @time: 9:59 下午
 * @description:
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult(44444, " 服务降级返回 ,---PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}
