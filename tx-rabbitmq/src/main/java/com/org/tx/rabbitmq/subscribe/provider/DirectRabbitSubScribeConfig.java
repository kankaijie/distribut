package com.org.tx.rabbitmq.subscribe.provider;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 订阅模式
 */
@Configuration
public class DirectRabbitSubScribeConfig {


    private static final String EXCHANGE_FANNOUT_NAME = "test_exchange_fanout";
    private static final String QUEUE_PS_SMS_NAME = "test_queue_fanout_sms";
    private static final String QUEUE_PS_EMAIL_NAME = "test_queue_fanout_email";


    /***
     * 交换机
     * @return
     */
    @Bean
    public FanoutExchange createFanoutExchange(){
        return new FanoutExchange(EXCHANGE_FANNOUT_NAME);
    }


    /***
     * 队列
     * @return
     */
    @Bean
    public Queue fanoutSmsQueue(){
        return new Queue(QUEUE_PS_SMS_NAME, false, false, false, null);
    }

    /***
     * 队列
     * @return
     */
    @Bean
    public Queue fanoutEmailQueue(){
        return new Queue(QUEUE_PS_EMAIL_NAME, false, false, false, null);
    }


    /***
     * 把队列绑定到交换机上
     * @param fanoutExchange
     * @param fanoutSmsQueue
     * @return
     */
    @Bean
    public Binding smsQueueExchangeBinding(FanoutExchange fanoutExchange, Queue fanoutSmsQueue){
        return BindingBuilder.bind(fanoutSmsQueue).to(fanoutExchange);
    }

    /***
     * 把队列绑定到交换机上
     * @param fanoutExchange
     * @param fanoutEmailQueue
     * @return
     */
    @Bean
    public Binding emailQueueExchangeBinding(FanoutExchange fanoutExchange, Queue fanoutEmailQueue){
        return BindingBuilder.bind(fanoutEmailQueue).to(fanoutExchange);
    }




}
