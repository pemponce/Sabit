package org.example.abstractFact;

public abstract class Pizza {
    public void prepare() {
        System.out.println("Preparing " + getClass().getSimpleName());
    }

    public void bake() {
        System.out.println("Baking " + getClass().getSimpleName());
    }

    public void cut() {
        System.out.println("Cutting " + getClass().getSimpleName());
    }

    public void box() {
        System.out.println("Boxing " + getClass().getSimpleName());
    }
}

