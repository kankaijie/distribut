package com.org.tx.rabbitmq.rout.provider;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 路由模式
 */
@Configuration
public class DirectRabbitRoutConfig {


    private static final String EXCHANGE_FANNOUT_NAME = "test_rout_fanout";
    private static final String QUEUE_PS_SMS_NAME = "test_queue_rout_sms";
    private static final String QUEUE_PS_EMAIL_NAME = "test_queue_rout_email";


    /***
     * 交换机
     * @return
     */
    @Bean
    public DirectExchange createDirectExchange(){
        return new DirectExchange(EXCHANGE_FANNOUT_NAME,true,false);
    }


    /***
     * 队列
     * @return
     */
    @Bean
    public Queue fanoutDirectSmsQueue(){
        return new Queue(QUEUE_PS_SMS_NAME, false, false, false, null);
    }

    /***
     * 队列
     * @return
     */
    @Bean
    public Queue fanoutDirectEmailQueue(){
        return new Queue(QUEUE_PS_EMAIL_NAME, false, false, false, null);
    }


    /***
     * 把队列绑定到交换机上
     * @param fanoutSmsQueue
     * @return
     */
    @Bean
    public Binding smsQueueDirectExchangeBinding( Queue fanoutSmsQueue){
        return BindingBuilder.bind(fanoutSmsQueue).to(createDirectExchange()).with("info");
    }

    /***
     * 把队列绑定到交换机上
     * @param fanoutEmailQueue
     * @return
     */
    @Bean
    public Binding emailQueueDirectDirectExchangeBinding(Queue fanoutEmailQueue){
        return BindingBuilder.bind(fanoutEmailQueue).to(createDirectExchange()).with("error");
    }




}
