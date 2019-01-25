package com.simile.mq.producer.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yitao on 2018/11/30.
 */
@Service
public class ProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    //发送队列消息
    public void send(String msg) {
        amqpTemplate.convertAndSend("hello", msg);
    }

    //发送广播消息
    public void top(String msg) {
        amqpTemplate.convertAndSend("topicExchange", "topicBinding", msg);
    }
}
