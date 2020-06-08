package com.org.tx.rabbitmq.work.poll.provider;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitWorkConfig {

    @Bean
    public Queue queueWork(){
        return new Queue("work_queue_poll",true);
    }
}
