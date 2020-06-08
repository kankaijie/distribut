package com.org.tx.rabbitmq.topic.provider;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *topic模式
 */
@Configuration
public class DirectRabbitTopicConfig {


    private static final String EXCHANGE_TOPIC_NAME = "topic_fanout";
    private static final String QUEUE_PS_SMS_NAME = "topic_goods.add";
    private static final String QUEUE_PS_EMAIL_NAME = "topic_goods_update";


    /***
     * 交换机
     * @return
     */
    @Bean
    public TopicExchange createTopExchange(){
        return new TopicExchange(EXCHANGE_TOPIC_NAME);
    }


    /***
     * 队列
     * @return
     */
    @Bean
    public Queue fanoutTopSmsQueue(){
        return new Queue(QUEUE_PS_SMS_NAME, false, false, false, null);
    }

    /***
     * 队列
     * @return
     */
    @Bean
    public Queue fanoutTopicEmailQueue(){
        return new Queue(QUEUE_PS_EMAIL_NAME, false, false, false, null);
    }


    /***
     * 把队列绑定到交换机上
     * @param
     * @return
     */
    @Bean
    public Binding smsQueueTopicExchangeBinding(){
        return BindingBuilder.bind(fanoutTopSmsQueue()).to(createTopExchange()).with("topic_goods.*");
    }

    /***
     * 把队列绑定到交换机上
     * @param
     * @return
     */
    @Bean
    public Binding emailQueueTopicExchangeBinding(){
        return BindingBuilder.bind(fanoutTopicEmailQueue()).to(createTopExchange()).with(QUEUE_PS_EMAIL_NAME);

    }




}
