package com.org.tx.rabbitmq.work.customer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static org.springframework.amqp.rabbit.core.RabbitAdmin.QUEUE_NAME;

@RabbitListener(queues = "work_queue")
@Component
public class DireReceiverWorkOne {

    private final static String QUEUE_NAME = "work_queue";

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @RabbitHandler
    public void processOne(String message) throws IOException {
        ConnectionFactory connectionFactory=rabbitTemplate.getConnectionFactory();
        Connection connection=connectionFactory.createConnection();
        Channel channelOne=connection.createChannel(false);
        //第二个参数true设置队列持久化
        channelOne.queueDeclare(QUEUE_NAME, true, false, false, null);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {


            //手动确认，如果设置为手动确认而不执行basicAck的话就会导致循环重复消费这些消息
            channelOne.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                //手动确认，如果设置为手动确认而不执行basicAck的话就会导致循环重复消费这些消息
//                channelOne.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
//            };

            System.out.println("消费者One:"+" 接收的消息:" + message );
        };

        //每次从队列中获取一个消息，设置为手动确认才有效
        channelOne.basicQos(1,false);

        //第二个参数设置为手动确认
        channelOne.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {});




            //        try {
            //            Thread.sleep(1000);
            //        } catch (InterruptedException e) {
            //            e.printStackTrace();
            //        }

    }

}
