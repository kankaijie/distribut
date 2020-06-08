package com.org.tx.rabbitmq.topic.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;


/***
 *消费者二
 */

@RabbitListener(queues = "topic_goods_update")
@Configuration
public class DirectTopicTwo {

    @RabbitHandler
    public void sendMessage(String message){
        System.out.println("==========我是=====");
        System.out.println("[goods_update] rev : " + message);
    }
}
