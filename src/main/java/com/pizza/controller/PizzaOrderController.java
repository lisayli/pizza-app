package com.pizza.controller;


import com.pizza.auth.UserRequest;
import com.pizza.entity.Pizza;
import com.pizza.service.PizzaService;
import com.pizza.service.RabbitMQSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*

 */
@RestController
@RequestMapping("api/v1/pizza")
@Api(tags = "Pizza Controller")
public class PizzaOrderController {

    private final PizzaService pizzaService;
    private final RabbitMQSender rabbitMQSender;

    @Autowired
    public PizzaOrderController(PizzaService pizzaService, RabbitMQSender rabbitMQSender) {
        this.pizzaService = pizzaService;
        this.rabbitMQSender = rabbitMQSender;
    }


    @GetMapping()
    public List<Pizza> getAllPizzas() {

        return pizzaService.getPizzas();
    }

    @GetMapping("{id}")
    @ApiOperation("Get pizza by ID")
    public Pizza getPizzaById(@PathVariable(value = "id") Long id) {
        return pizzaService.getPizzaById(id);
    }

    @PostMapping("/send/{id}")
    public String sendOrder(@RequestBody UserRequest userRequest, @PathVariable(value = "id") Long id) {
        Pizza pizza = pizzaService.getPizzaById(id);
        rabbitMQSender.send(userRequest);
        rabbitMQSender.sendOrderDetailsMessage(pizza);

        return "sent!";
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a pizza")
    public String deletePizzaById(@PathVariable(value = "id") Long id) {
        return pizzaService.deletePizzaById(id);
    }

    @PutMapping("/update/{id}")
    @ApiOperation("Update an existing pizza")
    public String updatePizzaName(@PathVariable(value = "id") Long id, String name) {
        return pizzaService.updatePizzaName(id, name);
    }

}
