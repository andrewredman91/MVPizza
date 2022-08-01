package com.codeclan.mvpizza.models;

public enum Toppings {
    margherita("thin", "tomato", "mozarella", "none"),
    pepperoni("thin", "tomato", "mozarella", "pepperoni");

    private final String base;
    private final String sauce;
    private final String cheese;
    private final String otherToppings;


    Toppings(String base, String sauce, String cheese, String otherToppings) {
        this.base = base;
        this.sauce = sauce;
        this.cheese = cheese;
        this.otherToppings = otherToppings;
    }

    public String getToppings(){
        return otherToppings;
    }
}
