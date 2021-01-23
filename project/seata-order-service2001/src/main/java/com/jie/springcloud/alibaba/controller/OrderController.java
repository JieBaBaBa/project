package com.jie.springcloud.alibaba.controller;

import com.jie.springcloud.alibaba.domain.Order;
import com.jie.springcloud.alibaba.service.OrderService;
import com.jie.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: chenxiaojie
 * @date: 2021/1/16
 * @time: 11:31 上午
 * @description:
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    // http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
