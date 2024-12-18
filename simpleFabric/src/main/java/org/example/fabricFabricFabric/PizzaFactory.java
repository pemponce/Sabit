package org.example.fabricFabricFabric;

// Фабрика для создания пиццы
public class PizzaFactory {
    public Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese")) {
            return new CheesePizza();
        } else if (type.equalsIgnoreCase("veggie")) {
            return new VeggiePizza();
        } else if (type.equalsIgnoreCase("pepperoni")) {
            return new PepperoniPizza();
        } else {
            throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
    }
}
