package org.example.InterfacesClass;

public interface EaterWithMock {
    void toEat(Food food) throws FoodException;

    static class MockEater implements EaterWithMock {
        @Override
        public void toEat(Food food) throws FoodException {
            System.out.println("Mocking eater ...");
        }
    }

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
        EaterWithMock.MockEater mockEater = new EaterWithMock.MockEater();
        try {
            mockEater.toEat(new EaterWithMock.Food("Pizza"));
        } catch (EaterWithMock.FoodException e) {
            System.out.println(e.getMessage());
        }
    }
}






