package org.example.car;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.nio.file.Paths;

public class Generate {
    public static void generateCarClass(String className, String engine, String gear, String brake) throws IOException {
        MethodSpec describeEngine = MethodSpec.methodBuilder("describeEngine")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addStatement("System.out.println($S)", "Engine: " + engine)
                .build();

        MethodSpec describeGear = MethodSpec.methodBuilder("describeGear")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addStatement("System.out.println($S)", "Gear: " + gear)
                .build();

        MethodSpec describeBrake = MethodSpec.methodBuilder("describeBrake")
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addStatement("System.out.println($S)", "Brake: " + brake)
                .build();

        TypeSpec carClass = TypeSpec.classBuilder(className) // генерация класса
                .addModifiers(Modifier.PUBLIC)
                .addMethod(describeEngine)
                .addMethod(describeGear)
                .addMethod(describeBrake)
                .build();

        JavaFile javaFile = JavaFile.builder("com.generated.cars", carClass)
                .build();

        javaFile.writeTo(Paths.get("./src/main/java"));
    }
}
