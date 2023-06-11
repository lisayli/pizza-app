package com.pizza.model;


import com.pizza.entity.Pizza;
import com.pizza.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

    private User user;
    private Pizza pizza;


}
