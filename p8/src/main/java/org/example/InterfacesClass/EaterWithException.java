package org.example.InterfacesClass;

public interface EaterWithException {
    void toEat(Food food) throws FoodException;

    public static class FoodException extends Exception {
        public FoodException(String message) {
            super(message);
        }
    }

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
        try {
            EaterWithException.Food food = new EaterWithException.Food("Orange");
            throw new EaterWithException.FoodException("FoodException: Cannot eat " + food.getId());
        } catch (EaterWithException.FoodException e) {
            System.out.println(e.getMessage());
        }
    }
}
