package org.example.abstractFact.service.impl;

import org.example.abstractFact.ItalianCheesePizza;
import org.example.abstractFact.ItalianVeggiePizza;
import org.example.abstractFact.Pizza;
import org.example.abstractFact.service.PizzaFactory;

public class ItalianPizzaFactory implements PizzaFactory {
    public Pizza createPizza(String type) {
        return switch (type) {
            case "cheese" -> new ItalianCheesePizza();
            case "veggie" -> new ItalianVeggiePizza();
            default -> null;
        };
    }
}
