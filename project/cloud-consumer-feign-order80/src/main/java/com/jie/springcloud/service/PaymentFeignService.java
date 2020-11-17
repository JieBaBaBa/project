package com.jie.springcloud.service;

import com.jie.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenxiaojie
 * @date: 2020/10/23
 * @time: 22:20
 * @description: TODO
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

//    CommonResult<Payment> getById(Long id);

    @GetMapping("/payment/get/{id}")
    CommonResult getById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();
}
