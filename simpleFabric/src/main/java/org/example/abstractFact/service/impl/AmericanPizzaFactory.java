package org.example.abstractFact.service.impl;

import org.example.abstractFact.AmericanCheesePizza;
import org.example.abstractFact.AmericanVeggiePizza;
import org.example.abstractFact.Pizza;
import org.example.abstractFact.service.PizzaFactory;

public class AmericanPizzaFactory implements PizzaFactory {
    public Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new AmericanCheesePizza();
            case "veggie" -> new AmericanVeggiePizza();
            default -> null;
        };
    }
}