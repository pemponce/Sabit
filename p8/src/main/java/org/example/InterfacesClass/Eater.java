package org.example.InterfacesClass;

public interface Eater {
    void toEat(Food food);

    static class Food {
        private final String id;

        public Food(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    public static void main(String[] args) {
        Eater.Food food = new Eater.Food("Apple");
        System.out.println("Food ID: " + food.getId());
    }
}