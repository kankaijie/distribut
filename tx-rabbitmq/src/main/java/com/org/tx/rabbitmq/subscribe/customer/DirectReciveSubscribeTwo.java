package com.org.tx.rabbitmq.subscribe.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;


/***
 *消费者二
 */
@Configuration
@RabbitListener(queues = "test_queue_fanout_email")
public class DirectReciveSubscribeTwo {

    @RabbitHandler
    public void sendMessage(String message){
        System.out.println("[email] rev : " + message);
    }
}
