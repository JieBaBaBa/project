package com.jie.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: chenxiaojie
 * @date: 2021/1/20
 * @time: 3:50 下午
 * @description:
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

    /**
     * id
     */
    private Long id;

    /**
     * 产品id
      */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;

}
