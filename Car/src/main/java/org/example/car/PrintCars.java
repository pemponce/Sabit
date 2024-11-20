package org.example.car;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PrintCars {
    public static void printCars(int engines, int gears, int brakes) throws Exception {

        int totalClasses = engines * gears * brakes;

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        File sourceDir = new File("./src/main/java/com/generated/cars");
        File[] sourceFiles = sourceDir.listFiles((dir, name) -> name.endsWith(".java"));
        if (sourceFiles != null) {
            for (File sourceFile : sourceFiles) {
                compiler.run(null, null, null, sourceFile.getPath());
            }
        }

        File outputDir = new File("./src/main/java");
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{outputDir.toURI().toURL()}); // загружаю сгенеренные файлы

        for (int i = 1; i <= totalClasses; i++) {
            String className = "com.generated.cars.CarCombination" + i;
            Class<?> carClass = Class.forName(className, true, classLoader);

            Object carInstance = carClass.getDeclaredConstructor().newInstance();
            System.out.println("CAR: " + i);
            System.out.println();
            carClass.getMethod("describeEngine").invoke(carInstance);
            carClass.getMethod("describeGear").invoke(carInstance);
            carClass.getMethod("describeBrake").invoke(carInstance);
            System.out.println();
        }
    }
}
