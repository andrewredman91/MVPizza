package com.codeclan.mvpizza.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pizzaType")
    private String pizzaType;

    @Column(name = "price")
    private int price;

    @Column(name = "stock")
    private int stock;


    @JsonBackReference
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
        name = "pizza_orders",
        joinColumns = {@JoinColumn(name = "pizza_id", nullable = false, updatable = false)},
        inverseJoinColumns = {@JoinColumn(name="order_id", nullable = false, updatable = false)}
    )
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Pizza(String pizzaType, int price, int stock) {
        this.pizzaType = pizzaType;
        this.price = price;
        this.stock = stock;
    }

    public Pizza(){
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void removeOnePizzaFromStock(){
        this.stock -=1;
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
}
