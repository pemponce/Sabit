package org.example;public class Main {
    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        store.orderPizza("cheese");
        System.out.println();

        store.orderPizza("veggie");
        System.out.println();

        store.orderPizza("pepperoni");
        System.out.println();

        store.orderPizza("clam");
        System.out.println();

        store.orderPizza("unknown");
    }
}