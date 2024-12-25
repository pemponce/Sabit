package org.example.abstractFact.service;

import org.example.abstractFact.Pizza;

public interface PizzaFactory {
    Pizza createPizza(String type);
}

