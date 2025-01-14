package org.example.abstractFact;

import org.example.abstractFact.service.PizzaFactory;
import org.example.abstractFact.service.impl.AmericanPizzaFactory;
import org.example.abstractFact.service.impl.ItalianPizzaFactory;

public class Main {
    public static void main(String[] args) {
        PizzaFactory italianFactory = new ItalianPizzaFactory();
        PizzaFactory americanFactory = new AmericanPizzaFactory();

        PizzaStore italianStore = new PizzaStore(italianFactory);
        PizzaStore americanStore = new PizzaStore(americanFactory);

        System.out.println("Ordering Italian Cheese Pizza:");
        italianStore.orderPizza("cheese");
        System.out.println();

        System.out.println("Ordering American Veggie Pizza:");
        americanStore.orderPizza("veggie");
        System.out.println();

        System.out.println("Ordering Italian Unknown Pizza:");
        italianStore.orderPizza("unknown");
    }
}