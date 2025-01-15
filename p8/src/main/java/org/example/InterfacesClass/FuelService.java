package org.example.InterfacesClass;

public interface FuelService {
    static class Formulas {
        public static void formula1() {
            System.out.println("Executing formula1...");
        }

        public static void formula2() {
            System.out.println("Executing formula2...");
        }

        public static void formula3() {
            System.out.println("Executing formula3...");
        }
    }

    public static void main(String[] args) {
        FuelService.Formulas.formula1();
        FuelService.Formulas.formula2();
        FuelService.Formulas.formula3();
    }
}
