package com.org.tx.rabbitmq.rout.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;


/***
 * 消费者一
 */
@RabbitListener(queues = "test_queue_rout_sms")
@Configuration
public class DirectReciveRoutOne {


    @RabbitHandler
    public void sendMessage(String message){
        System.out.println("[sms] rev : " + message);
    }

}
