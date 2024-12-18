package com.example.lombok;

import com.example.lombok.models.Car;
import com.example.lombok.models.Plane;
import com.example.lombok.models.User;
import com.example.lombok.service.CarService;
import com.example.lombok.service.PlaneService;
import com.example.lombok.service.UserService;
import com.example.lombok.service.impl.CarServiceImpl;
import com.example.lombok.service.impl.PlaneServiceImpl;
import com.example.lombok.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LombokApplication implements CommandLineRunner {

    @Autowired
    Starter starter;

    public static void main(String[] args) {
        SpringApplication.run(LombokApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        starter.start();
    }
}


/*
TODO:
 jML
 */