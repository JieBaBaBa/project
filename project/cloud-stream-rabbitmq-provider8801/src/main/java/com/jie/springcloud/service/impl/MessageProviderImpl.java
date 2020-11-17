package com.jie.springcloud.service.impl;

import com.jie.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author chenxiaojie
 * @date: 2020/11/9
 * @time: 22:08
 * @description: TODO
 */
@EnableBinding(Source.class) //定义消息的推送挂管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("------------serial:" + serial);
        return null;
    }
}
