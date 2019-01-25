package com.simile.mq.producer.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by yitao on 2018/11/30.
 */
@Component
public class SubscribeService {

    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void hello(String msg, Channel channel, Message message) {
        try {
            System.out.println("hello.suc:" + msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            System.out.println("hello.fail:" + msg);
        }
    }

    @RabbitListener(queues = "topQueue")
    @RabbitHandler
    public void top(String msg, Channel channel, Message message) {
        try {
            System.out.println("top.suc:" + msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        } catch (IOException e) {
            System.out.println("top.fail:" + msg);
        }
    }

}
