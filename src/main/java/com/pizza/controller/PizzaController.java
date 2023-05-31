package com.pizza.controller;


import com.pizza.entity.Pizza;
import com.pizza.service.PizzaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
@Api(tags = "Pizza Controller")
public class PizzaController {

    private final PizzaService pizzaService;
    private final RabbitMQSender rabbitMQSender;

    @Autowired
    public PizzaController(PizzaService pizzaService, RabbitMQSender rabbitMQSender) {
        this.pizzaService = pizzaService;
        this.rabbitMQSender = rabbitMQSender;
    }


    @GetMapping("/getall")
    public List<Pizza> getAllPizzas() {
        return pizzaService.getPizzas();
    }

    @GetMapping("{id}")
    @ApiOperation("Get pizza by ID")
    public Pizza getPizzaById(@PathVariable(value = "id") Long id) {
        return pizzaService.getPizzaById(id);
    }

    @PostMapping("/add")
    @ApiOperation("Create a new pizza")
    public Pizza createPizza(@RequestBody Pizza pizza) {
        rabbitMQSender.sendMessage(pizza);
        return pizzaService.createPizza(pizza);
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
