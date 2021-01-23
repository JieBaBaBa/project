package com.jie.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jie.springcloud.entities.CommonResult;

/**
 * @author: chenxiaojie
 * @date: 2021/1/5
 * @time: 9:43 下午
 * @description:
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException e) {
        return new CommonResult(2020, "自定义限流处理信息 ....CustomerBlockHandler");
    }
}
