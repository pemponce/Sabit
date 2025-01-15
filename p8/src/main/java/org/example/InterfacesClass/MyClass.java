package org.example.InterfacesClass;

public class MyClass {
    public interface FuelAssessmentService {
        void calculate(RoadType rt);

        enum RoadType { RT1, RT2, RT3 }
    }
}