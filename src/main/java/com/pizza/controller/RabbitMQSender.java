package com.pizza.controller;

import com.pizza.config.MessagingConfig;
import com.pizza.entity.Pizza;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String sendMessage(Pizza pizzaInfo) {
        rabbitTemplate.convertAndSend(
                MessagingConfig.EXCHANGE,
                MessagingConfig.ROUTING_KEY, pizzaInfo);
        return "SUCCESS!!";
    }
}

