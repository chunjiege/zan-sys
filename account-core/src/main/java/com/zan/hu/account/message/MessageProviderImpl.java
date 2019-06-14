package com.zan.hu.account.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author hupeng
 * @Date 2019-05-26 10:59
 * @Description todo
 **/
@EnableBinding(Source.class) // 可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output; // 消息的发送管道

    @Override
    public void  send(String company) {
        this.output.send(MessageBuilder.withPayload(company).build()); // 创建并发送消息
        System.out.println("消息发送成功");
    }
}
