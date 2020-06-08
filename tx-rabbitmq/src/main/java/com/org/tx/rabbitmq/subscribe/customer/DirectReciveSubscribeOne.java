package com.org.tx.rabbitmq.subscribe.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;


/***
 * 消费者一
 */
@Configuration
@RabbitListener(queues = "test_queue_fanout_sms")
public class DirectReciveSubscribeOne {


    @RabbitHandler
    public void sendMessage(String message){
        System.out.println("[sms] rev : " + message);
    }

}
