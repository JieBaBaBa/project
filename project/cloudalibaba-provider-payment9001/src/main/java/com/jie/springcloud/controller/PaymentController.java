package com.jie.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
*@author:chenxiaojie
*@date:2020/12/13
*@time:11:33上午
*@description:
*/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    
    @GetMapping(value="/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacosregistry,serverPort:"+ serverPort+"\t id"+id;
    }
}
