package com.simile.mq.producer.service;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yitao on 2018/12/12.
 */
@Configuration
public class RabbitQueueConfig {

    @Bean
    public Queue hello() {
        Queue queue = new Queue("hello");
        return queue;
    }

    @Bean("top")
    public Queue top() {
        Queue queue = new Queue("topQueue");
        return queue;
    }

    @Bean("topic")
    public TopicExchange topic() {
        TopicExchange queue = new TopicExchange("topicExchange");
        return queue;
    }

    @Bean
    public Binding bindingTopic(@Qualifier("top") Queue queue,@Qualifier("topic") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("topQueue");
    }


}
