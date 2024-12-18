package org.example.fabricFabricFabric;

public class Main {
    public static void main(String[] args) {
        FactoryOfFactories factoryOfFactories = new FactoryOfFactories();
        
        RegionalPizzaFactory regionalFactory = factoryOfFactories.createRegionalFactory();
        
        PizzaFactory pizzaFactory = regionalFactory.createFactory("New York");
        
        Pizza pizza = pizzaFactory.createPizza("cheese");
        Pizza pizza1 = pizzaFactory.createPizza("pepperoni");

        System.out.println("Created: " + pizza.getName() + " " + regionalFactory.getRegion());
        System.out.println("Created: " + pizza1.getName() + " " + regionalFactory.getRegion());
    }
}
