package org.example.threads;

import org.example.classic.Singleton;

public class SynchronizedSingleton {
    private static SynchronizedSingleton uniqueInstance;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SynchronizedSingleton();
        }
        return uniqueInstance;
    }
}
