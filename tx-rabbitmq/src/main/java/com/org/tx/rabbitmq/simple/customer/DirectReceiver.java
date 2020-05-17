package com.org.tx.rabbitmq.simple.customer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;


/***
 * 消费者
 */
@Configuration
public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void process(String message) {
        System.out.println("DirectReceiver消费者收到消息  : " + message);
    }



}
