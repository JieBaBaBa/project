package com.jie.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author: chenxiaojie
 * @date: 2021/1/23
 * @time: 10:18 上午
 * @description:
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long id;

    /**
      * 用户id
      */
    private Long userId;

    /**
      * 总额度
      */
    private BigDecimal total;

    /**
      * 已用额度
      */
    private BigDecimal used;

    /**
      * 剩余额度
      */
    private BigDecimal residue;

}
