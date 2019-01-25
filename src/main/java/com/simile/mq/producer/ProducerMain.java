package com.simile.mq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by yitao on 2018/11/30.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com"})
public class ProducerMain extends SpringBootServletInitializer {

    public static void main(String[] args){
        SpringApplication.run(ProducerMain.class, args);
    }

}
