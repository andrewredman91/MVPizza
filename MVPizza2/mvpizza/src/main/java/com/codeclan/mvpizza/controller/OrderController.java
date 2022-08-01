package com.codeclan.mvpizza.controller;

import com.codeclan.mvpizza.models.Order;
import com.codeclan.mvpizza.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
//pass in a placeholder
    // post with a request param of pizza id
    //looks up gets the pizza
    //in the pizza repository for the pizza
    //deduct 1 if stock is greater than 1
    // if stock is greater or = 1 make pizza, if not return error to front end
    //if fails
    @Autowired
    OrderRepository orderRepository;

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }
}
