package com.jie.springcloud.alibaba.controller;

import com.jie.springcloud.alibaba.service.AccountService;
import com.jie.springcloud.entities.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author: chenxiaojie
 * @date: 2021/1/23
 * @time: 10:27 上午
 * @description:
 */
@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    /**
      * 扣减账户余额
      */
    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"扣减账户余额成功！");
    }
}
