package com.jie.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxiaojie
 * @date: 2020/11/4
 * @time: 21:55
 * @description: TODO
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${eureka.client.service-url.defaultZone}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
