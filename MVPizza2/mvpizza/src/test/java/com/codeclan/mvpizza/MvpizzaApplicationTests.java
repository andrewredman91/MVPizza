package com.codeclan.mvpizza;


import com.codeclan.mvpizza.models.Order;
import com.codeclan.mvpizza.models.Pizza;
import com.codeclan.mvpizza.repository.OrderRepository;
import com.codeclan.mvpizza.repository.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class MvpizzaApplicationTests {

	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	OrderRepository orderRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createPizzaOrder(){
//		List<Pizza> pizzaArrayList = new ArrayList<>();
		Pizza margherita = new Pizza("margherita", 10, 99);
		pizzaRepository.save(margherita);
		Pizza pepperoni = new Pizza("pepperoni", 11, 99);
		pizzaRepository.save(pepperoni);
		Pizza hawaiian = new Pizza("hawaiian", 11, 99);
		pizzaRepository.save(hawaiian);

		Order order1 = new Order();
		orderRepository.save(order1);
		Order order2 = new Order();
		orderRepository.save(order2);
		Order order3 = new Order();
		orderRepository.save(order3);

		order1.addPizza(margherita);
		orderRepository.save(order1);
		order2.addPizza(pepperoni);
		orderRepository.save(order2);
		order3.addPizza(hawaiian);
		orderRepository.save(order3);


	}

}
