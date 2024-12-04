package com.example.lombok.service.impl;

import com.example.lombok.models.Car;
import com.example.lombok.repository.CarRepository;
import com.example.lombok.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void print() {

        System.out.println(carRepository.getAll().toString());

    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }
}
