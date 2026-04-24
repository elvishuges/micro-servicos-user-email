package com.ms.email.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Configuration;

import tools.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;

@Configuration
public class RabbitMQConfig {

    @Value("${broker.queue.email.name}")
    private String queue;

    @Bean
    public Queue queue() {
        return new Queue(queue, true);
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter() {
        return new JacksonJsonMessageConverter();
    }
}
