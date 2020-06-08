package com.org.tx.rabbitmq.topic.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


/***
 * topic主题模式
 */
@Configuration
public class SendMessageTopicController {



    private static final String EXCHANGE_TOPIC_NAME = "topic_fanout";
    private static final String QUEUE_PS_SMS_NAME = "topic_goods.add";
    private static final String QUEUE_PS_EMAIL_NAME = "topic_goods_update";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(){
        for(int i=1;i<=20;i++){
            String message="我是Topic匹配模式=="+i;
            rabbitTemplate.convertAndSend(EXCHANGE_TOPIC_NAME,QUEUE_PS_SMS_NAME,message);
            rabbitTemplate.convertAndSend(EXCHANGE_TOPIC_NAME,QUEUE_PS_EMAIL_NAME,message);
            System.out.println(" [x] Sent '" + message + "'");
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
