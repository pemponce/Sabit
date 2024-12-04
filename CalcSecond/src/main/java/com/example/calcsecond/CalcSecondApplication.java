package com.example.calcsecond;

import com.example.firstCalc.service.impl.CalcServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalcSecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalcSecondApplication.class, args);
		CalcServiceImpl calcService = new CalcServiceImpl();
		System.out.println(calcService.add(1, 2));
	}

}
