package com.jie.springcloud.controller;

import com.jie.springcloud.entities.CommonResult;
import com.jie.springcloud.entities.Payment;
import com.jie.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author chenxiaojie
 * @date: 2020/9/12
 * @time: 13:10
 * @description: TODO
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getById(id);
        log.info("-------------");
        return new CommonResult(200, "成功，serverPort：" + serverPort, payment);
    }

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结束！");
        if (result > 0) {
            return new CommonResult(200, "成功，serverPort：" + serverPort, result);
        }
        return new CommonResult(444, "失败，serverPort：" + serverPort, result);
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}


