package com.jie.springcloud.controller;

import com.jie.springcloud.entities.CommonResult;
import com.jie.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: chenxiaojie
 * @date: 2021/1/5
 * @time: 10:08 下午
 * @description:
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static Map<Long, Payment> hashMap = new HashMap <>();

    static {
        hashMap.put (1L, new Payment(1L, "28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put (2L, new Payment(2L, "28a8c1e3bc2742d8848569891fb42182"));
        hashMap.put (3L, new Payment(3L, "28a8c1e3bc2742d8848569891fb42183"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult <Payment> result = new CommonResult(200, "from mysql,serverPort: " + serverPort, payment);
        return result;
    }
}
