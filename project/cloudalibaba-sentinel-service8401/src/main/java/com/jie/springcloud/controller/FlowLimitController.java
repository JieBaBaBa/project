package com.jie.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author: chenxiaojie
 * @date: 2020/12/30
 * @time: 7:51 下午
 * @description:
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA () {
        // 线程数
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            log.error("error!");
//        }
        log.info(Thread.currentThread().getName() + "---->testA");
        System.out.println(Thread.currentThread().getName() + "---->testA");
        return "------testA" ;
    }

    @GetMapping("/testB")
    public String testB () {
        log.info(Thread.currentThread().getName() + "---->testB");
        System.out.println(Thread.currentThread().getName() + "---->testB");
        return "------testB" ;
        // QPS 排队等待 高并发，过了阀值，一个一个排队
    }

    @GetMapping("/testD")
    public String testD () {
//        try {
//            TimeUnit.SECONDS.sleep( 1);
//        } catch (InterruptedException e) {
//            log.error("error!");
//        }
//        log.info( "testD 测试 RT" );

        log.info( "testD 测试 异常比例" );
        int a = 10 / 0;
        return "------testD" ;
    }

    @GetMapping("/testE")
    public String testE () {
        log.info( "testE 测试 异常数" );
        int a = 10 / 0;
        return "------testE" ;
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey (@RequestParam(value = "p1", required = false) String p1,
                              @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException e) {
        return "deal_testHotKey来了！";
    }
}
