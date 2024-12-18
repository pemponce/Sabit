package org.example.fabricFabricFabric;

// Фабрика фабрик, создающая фабрики для разных регионов
public class RegionalPizzaFactory {

    private static String region;

    public PizzaFactory createFactory(String region) {
        RegionalPizzaFactory.region = region;
        if (region.equalsIgnoreCase("New York")) {
            return new PizzaFactory();
        } else if (region.equalsIgnoreCase("Chicago")) {
            return new PizzaFactory();
        } else {
            throw new IllegalArgumentException("Unknown region: " + region);
        }
    }

    public String getRegion() {
        return region;
    }
}
