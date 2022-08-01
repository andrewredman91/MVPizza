package com.codeclan.mvpizza.controller;

import com.codeclan.mvpizza.models.Pizza;
import com.codeclan.mvpizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PizzaController {

    @Autowired
    PizzaRepository pizzaRepository;

    @GetMapping(value = "/pizzas")
    public ResponseEntity<List<Pizza>> getAllPizzas(){
        return new ResponseEntity<>(pizzaRepository.findAll(Sort.by("id")), HttpStatus.OK);
    }
}
