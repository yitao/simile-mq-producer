package com.simile.mq.producer.controller;

import com.simile.mq.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yitao on 2018/11/30.
 */
@RestController
@RequestMapping("/msg")
public class MsgController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/send")
    public String send(String msg) {
        producerService.send(msg);
        producerService.top(msg);
        return msg;
    }

}
