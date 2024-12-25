package org.example.abstractFact;

import org.example.abstractFact.service.PizzaFactory;

class PizzaStore {
    private final PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);

        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } else {
            System.out.println("Sorry, we don't make that kind of pizza.");
        }
        return pizza;
    }
}