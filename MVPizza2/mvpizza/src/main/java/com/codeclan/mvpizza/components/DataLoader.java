package com.codeclan.mvpizza.components;

import com.codeclan.mvpizza.models.Order;
import com.codeclan.mvpizza.models.Pizza;
import com.codeclan.mvpizza.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Profile("!test") //Run every time EXCEPT Tests
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PizzaRepository pizzaRepository;
    @Autowired
    OrderRepository orderRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args) {
        Pizza margherita = new Pizza("margherita", 10, 99);
        pizzaRepository.save(margherita);
        Pizza pepperoni = new Pizza("pepperoni", 11, 99);
        pizzaRepository.save(pepperoni);
        Pizza hawaiian = new Pizza("hawaiian", 11, 99);
        pizzaRepository.save(hawaiian);

//        ArrayList<Pizza> pizzaArrayList = new ArrayList<>();
//        pizzaArrayList.add(margherita);
//        pizzaArrayList.add(pepperoni);
        Order order1 = new Order();
        orderRepository.save(order1);
        Order order2 = new Order();
        orderRepository.save(order2);
        Order order3 = new Order();
        orderRepository.save(order3);

        order1.addPizza(hawaiian);
        orderRepository.save(order1);


    }

}
