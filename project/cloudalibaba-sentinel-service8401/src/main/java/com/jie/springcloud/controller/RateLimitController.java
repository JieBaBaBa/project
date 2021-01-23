package com.jie.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jie.springcloud.entities.CommonResult;
import com.jie.springcloud.entities.Payment;
import com.jie.springcloud.handle.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenxiaojie
 * @date: 2021/1/4
 * @time: 5:02 下午
 * @description:
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试 OK", new Payment(2020L , "serial001"));
    }

    public CommonResult handleException(BlockException e) {
        return new CommonResult(400, e.getClass().getCanonicalName(), "服务不可用！");
    }

    @GetMapping ("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按资源名称限流测试 OK", new Payment(2020L , "serial001"));
    }

    @GetMapping ("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handleException")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客戶自定义 OK", new Payment(2020L , "serial002"));
    }

}
