package com.org.tx.rabbitmq.work.fair.provider;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitWorkFailConfig {

    @Bean
    public Queue queueFailWork(){
        return new Queue("work_queue_fail",true);
    }
}
