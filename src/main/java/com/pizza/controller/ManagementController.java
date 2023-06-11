package com.pizza.controller;


import com.pizza.entity.Pizza;
import com.pizza.service.PizzaService;
import com.pizza.service.RabbitMQSender;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
@Tag(name = "Management")
public class ManagementController {

    private final PizzaService pizzaService;
    private final RabbitMQSender rabbitMQSender;

    public ManagementController(PizzaService pizzaService, RabbitMQSender rabbitMQSender) {
        this.pizzaService = pizzaService;
        this.rabbitMQSender = rabbitMQSender;
    }

    @GetMapping
    public String get() {
        return "GET:: management controller";
    }
    @PostMapping
    public String post() {
        return "POST:: management controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: management controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: management controller";
    }

    @PostMapping("/create")
    @ApiOperation("Create a new pizza")
    public Pizza createPizza(@RequestBody Pizza pizza) {
        rabbitMQSender.sendOrderDetailsMessage(pizza);
        return pizzaService.createPizza(pizza);
    }
}
