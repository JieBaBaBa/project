package com.jie.springcloud.alibaba.dao;

import com.jie.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: chenxiaojie
 * @date: 2021/1/16
 * @time: 11:12 上午
 * @description:
 */
@Mapper
public interface OrderDao {


    /**
     * 新建订单
     *
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态，从零改为1
     *
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
