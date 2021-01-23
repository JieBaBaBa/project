package com.jie.springcloud.alibaba.serivce.impl;

import com.jie.springcloud.alibaba.dao.StorageDao;
import com.jie.springcloud.alibaba.serivce.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: chenxiaojie
 * @date: 2021/1/20
 * @time: 6:14 下午
 * @description:
 */
@Slf4j
@Service("storageService")
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}
