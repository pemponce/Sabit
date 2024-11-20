package org.example.car;


import java.io.IOException;

public class CarClassGenerator {
    public static void main(String[] args) throws IOException {
        String[] engines = {"V6", "V8", "Electrichka", "Gibrid", "Dizel"};
        String[] gears = {"Mehanicheskaya", "Avtomaticheskaya", "Sekventalka", "Variator"};
        String[] brakes = {"ABS", "Discovie", "Barabannie", "Rekuperativnii"};

        int classCounter = 1;

        for (String engine : engines) {
            for (String gear : gears) {
                for (String brake : brakes) {
                    String className = "CarCombination" + classCounter++;
                    Generate.generateCarClass(className, engine, gear, brake);
                }
            }
        }

        try {
            PrintCars.printCars(engines.length, gears.length, brakes.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
