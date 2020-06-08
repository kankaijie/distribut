package com.org.tx.rabbitmq.subscribe.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendMessageSubscribleController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(){
        for(int i=1;i<=20;i++){
            String message="我是订阅模式=="+i;
            rabbitTemplate.convertAndSend("test_exchange_fanout","",message);
            System.out.println(" [x] Sent '" + message + "'");
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
