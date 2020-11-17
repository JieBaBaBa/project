package com.jie.springcloud.controller;

import com.jie.springcloud.entities.CommonResult;
import com.jie.springcloud.entities.Payment;
import com.jie.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author chenxiaojie
 * @date: 2020/10/23
 * @time: 22:28
 * @description: TODO
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id) {
        /// return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        return paymentFeignService.getById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        // openfeign-ribbon，客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }

}
