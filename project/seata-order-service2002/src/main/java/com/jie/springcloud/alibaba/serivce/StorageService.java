package com.jie.springcloud.alibaba.serivce;

/**
 * @author: chenxiaojie
 * @date: 2021/1/20
 * @time: 6:13 下午
 * @description:
 */
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);

}
