package org.example.threads;

public class SynchronizedBlockSingleton {
    private volatile static SynchronizedBlockSingleton uniqueInstance;
    private SynchronizedBlockSingleton() {}
    public static SynchronizedBlockSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (SynchronizedBlockSingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SynchronizedBlockSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}
