package com.example.firstCalc;

import com.example.firstCalc.service.CalcService;
import com.example.firstCalc.service.impl.CalcServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalcApplication.class, args);
    }

}
