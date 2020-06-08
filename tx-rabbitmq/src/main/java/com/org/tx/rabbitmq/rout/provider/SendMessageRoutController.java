package com.org.tx.rabbitmq.rout.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendMessageRoutController {

    private static final String EXCHANGE_FANNOUT_NAME = "test_rout_fanout";
    private static final String ROUT_INFO="info";
    private static final String ROUT_ERROR="error";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(){
        for(int i=1;i<=20;i++){
            String message="我是路由模式=="+i;
            rabbitTemplate.convertAndSend(EXCHANGE_FANNOUT_NAME,ROUT_INFO,message);
            rabbitTemplate.convertAndSend(EXCHANGE_FANNOUT_NAME,ROUT_ERROR,message);
            System.out.println(" [x] Sent '" + message + "'");
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
