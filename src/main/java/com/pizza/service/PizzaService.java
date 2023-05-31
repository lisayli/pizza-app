package com.pizza.service;

import com.pizza.entity.Pizza;
import com.pizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Pizzza with what ID"));
    }

    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }


    public String deletePizzaById(Long id) {
        Pizza pizzaToDelete = getPizzaById(id);
        if (pizzaToDelete == null) {
            return "Pizza with ID: " + pizzaToDelete + " does not exist..";
        }
        return pizzaToDelete.getName() + " is removed!";
    }

    public String updatePizzaName(Long id, String name) {
        Pizza pizzaToUpdate = getPizzaById(id);
        if (pizzaToUpdate == null) {
            return "Pizza with ID: " + pizzaToUpdate + " does not exist..";
        }
        pizzaToUpdate.setName(name);
        return pizzaToUpdate + " is updated!";

    }


}



