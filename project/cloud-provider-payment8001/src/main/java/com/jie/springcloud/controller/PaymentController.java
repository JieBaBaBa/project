package com.jie.springcloud.controller;

import com.jie.springcloud.entities.CommonResult;
import com.jie.springcloud.entities.Payment;
import com.jie.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("key: " ,service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId());
            log.info(instance.getHost());
            log.info(String.valueOf(instance.getPort()));
            log.info(String.valueOf(instance.getUri()));
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeOut() {

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}


