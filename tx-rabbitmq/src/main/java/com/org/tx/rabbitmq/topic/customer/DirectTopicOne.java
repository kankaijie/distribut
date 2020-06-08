package com.org.tx.rabbitmq.topic.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;


/***
 * 消费者一
 */
@RabbitListener(queues = "topic_goods.add")
@Configuration
public class DirectTopicOne {


    @RabbitHandler
    public void sendMessage(String message){

        System.out.println("[goods_add] rev : " + message);
    }

}
