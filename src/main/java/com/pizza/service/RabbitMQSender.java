package com.pizza.service;

import com.pizza.auth.UserRequest;
import com.pizza.config.MessagingConfig;
import com.pizza.entity.Pizza;
import com.pizza.entity.User;
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

    public String sendOrderDetailsMessage(Pizza pizzaInfo) {
        rabbitTemplate.convertAndSend(
                MessagingConfig.EXCHANGE,
                MessagingConfig.ROUTING_KEY, pizzaInfo);
        return "SUCCESS!!";
    }

    public String send(UserRequest userRequest) {
        rabbitTemplate.convertAndSend(
                MessagingConfig.EXCHANGE,
                MessagingConfig.ROUTING_KEY, userRequest);
        return "SUCCESS!!";
    }

    public String sendUserDetailsMessage(User userInfo) {
        rabbitTemplate.convertAndSend(
                MessagingConfig.EXCHANGE,
                MessagingConfig.ROUTING_KEY, userInfo);
        return "SUCCESS!!";
    }

}

