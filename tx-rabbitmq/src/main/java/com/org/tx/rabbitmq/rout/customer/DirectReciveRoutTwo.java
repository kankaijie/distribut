package com.org.tx.rabbitmq.rout.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;


/***
 *消费者二
 */

@RabbitListener(queues = "test_queue_rout_email")
@Configuration
public class DirectReciveRoutTwo {

    @RabbitHandler
    public void sendMessage(String message){
        System.out.println("[email] rev : " + message);
    }
}
