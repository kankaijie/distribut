package com.org.tx.rabbitmq.work.fair.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendMessageWorkFailController {

    @Autowired
    private RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法


    public void sendMessage(){
        for(int i=1;i<=20;i++){
            String message="我是工作队列模式=="+i;
            rabbitTemplate.convertAndSend("work_queue_fail",message);
            System.out.println(" [x] Sent '" + message + "'");
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
