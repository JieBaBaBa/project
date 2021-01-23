package com.jie.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chenxiaojie
 * @date: 2021/1/16
 * @time: 11:41 上午
 * @description:
 */
@Configuration
@MapperScan("{com.jie.springcloud.alibaba.dao}")
public class MyBatisConfig {
}
