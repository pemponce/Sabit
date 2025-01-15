package org.example.threads;

public enum EnumSingleton {
    INSTANCE;

    // Дополнительные методы
    public void someMethod() {
        System.out.println("Enum Singleton instance is working!");
    }
}