package com.jie.springcloud.dao;

import com.jie.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenxiaojie
 * @date: 2020/9/12
 * @time: 12:50
 * @description: TODO
 */
@Mapper
public interface PaymentDao {

    Payment getById(@Param("id") Long id);

    int create(@Param("payment") Payment payment);
}
