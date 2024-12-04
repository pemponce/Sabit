package com.example.lombok;

import com.example.lombok.models.Car;
import com.example.lombok.models.Plane;
import com.example.lombok.models.User;
import com.example.lombok.service.CarService;
import com.example.lombok.service.PlaneService;
import com.example.lombok.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Starter {

    @Autowired
    CarService carService;
    @Autowired
    PlaneService planeService;
    @Autowired
    UserService userService;


    public void start() {
        Car car = Car.builder()
                .year(2002)
                .color("green")
                .model("Z4")
                .brand("BMW")
                .build();

        carService.save(car);
        carService.print();


////////////////

        Plane plane = new Plane();

        plane.setBrand("Airbus");
        plane.setColor("Blue");
        plane.setModel("A-320");
        plane.setYear(2008);

        planeService.save(plane);
///////////////
        User user = new User(14, 165, "Artne", "Kazah");

        userService.save(user);


        carService.print();
        planeService.print();
        userService.print();
    }
}
