package com.jie.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author: chenxiaojie
 * @date: 2021/1/23
 * @time: 10:23 上午
 * @description:
 */
public interface AccountService {

    /**
      * 扣减账户余额
      */
    void decrease(Long userId, BigDecimal money);
}
