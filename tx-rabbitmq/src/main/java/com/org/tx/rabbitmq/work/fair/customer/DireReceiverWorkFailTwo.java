package com.org.tx.rabbitmq.work.fair.customer;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@RabbitListener(queues = "work_queue_fail")
@Configuration
public class DireReceiverWorkFailTwo {

    private final static String QUEUE_NAME = "work_queue_fail";

    @Autowired
    private RabbitTemplate rabbitTemplate;


    /***
     * 公平分发
     * @param message
     * @throws IOException
     */
    @RabbitHandler
    public void processTwo(String message) throws IOException {
        ConnectionFactory connectionFactory=rabbitTemplate.getConnectionFactory();
        Connection connection=connectionFactory.createConnection();
        Channel channelOne=connection.createChannel(false);
        //第二个参数true设置队列持久化
        channelOne.queueDeclare(QUEUE_NAME, true, false, false, null);

        //每次从队列中获取一个消息，设置为手动确认才有效
        channelOne.basicQos(1,false);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            //手动确认，如果设置为手动确认而不执行basicAck的话就会导致循环重复消费这些消息
            channelOne.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //手动确认，如果设置为手动确认而不执行basicAck的话就会导致循环重复消费这些消息
                channelOne.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            };
            System.out.println("消费者Two:"+" 接收的消息:" + message );
        };

        //第二个参数设置为手动确认
        channelOne.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {});

    }
}
