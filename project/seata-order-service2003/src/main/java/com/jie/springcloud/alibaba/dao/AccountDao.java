package com.jie.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author: chenxiaojie
 * @date: 2021/1/23
 * @time: 10:20 上午
 * @description:
 */
@Mapper
public interface AccountDao {

    /**
      * 扣减账户余额
      */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
