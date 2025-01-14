package org.example.threads;

public class InitializedSingleton {

    private static final InitializedSingleton uniqueInstance = new InitializedSingleton();

    private InitializedSingleton() {}

    public static synchronized InitializedSingleton getInstance() {
        return uniqueInstance;
    }

}
