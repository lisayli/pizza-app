package com.pizza.controller;

import com.pizza.entity.Pizza;
import com.pizza.service.PizzaService;
import com.pizza.user.User;
import com.pizza.user.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;

public class OrderController {


    private final RabbitMQSender rabbitMQSender;
    private final PizzaService pizzaService;
   private final UserRepository userRepository;
    public OrderController(RabbitMQSender rabbitMQSender, UserRepository userRepository, PizzaService pizzaService) {
        this.rabbitMQSender = rabbitMQSender;
        this.pizzaService = pizzaService;
        this.userRepository = userRepository;
    }


    public String createOrder(@PathVariable(value = "userId") Long userId, @PathVariable(value = "pizzaId") Long pizzaId){
        Pizza pizza = pizzaService.getPizzaById(pizzaId);
        User user = userRepository.getReferenceById(userId);
        rabbitMQSender.sendOrderDetailsMessage(pizza);
        rabbitMQSender.sendUserDetailsMessage(user);
        return "Order is sent.";
    }
}
