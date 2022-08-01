package com.codeclan.mvpizza.controller;


import com.codeclan.mvpizza.models.Cooking;
import com.codeclan.mvpizza.models.Pizza;

//import com.codeclan.mvpizza.repository.CookingRepository;
import com.codeclan.mvpizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CookingController {

//    @Autowired
//    private CookingRepository cookingRepository;

    @Autowired
    private PizzaRepository pizzaRepository;


    @PostMapping("/cooking/{pizza_id}")
    public ResponseEntity<Pizza> cookThePizza(@PathVariable Long pizza_id ) {

//        System.out.println(pizza_id);
//        Cooking cookingPizza = new Cooking();

        Optional<Pizza> pizzaInServer = pizzaRepository.findById(pizza_id);
        if(pizzaInServer.get().getStock()>0){
            pizzaInServer.get().removeOnePizzaFromStock();
            pizzaRepository.save(pizzaInServer.get());
//            cookingPizza.setCooked(true);


            return new ResponseEntity<>(pizzaInServer.get(),HttpStatus.OK);
        }
        else {
//            cookingPizza.setCooked(false);
//            cookingPizza.setMessageForFrontEnd("Out of Stock");
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }


}


