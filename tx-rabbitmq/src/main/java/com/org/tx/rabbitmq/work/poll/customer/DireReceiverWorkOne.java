package com.org.tx.rabbitmq.work.poll.customer;



import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@RabbitListener(queues = "work_queue_poll")
@Configuration
public class DireReceiverWorkOne {


    /***
     * 轮询分发
     * @param message
     * @throws IOException
     */
    @RabbitHandler
    public void processOne(String message) throws IOException {
        try {
            System.out.println("消费者One:"+" 接收的消息:" + message );
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
