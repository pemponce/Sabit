package org.example;

public class StaticInitializerSingleton {

    private static final StaticInitializerSingleton uniqueInstance;

    static {
        uniqueInstance = new StaticInitializerSingleton();
    }

    private StaticInitializerSingleton() {
    }

    public static StaticInitializerSingleton getUniqueInstance() {
        return uniqueInstance;
    }
}
