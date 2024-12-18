package com.example.lombok.service.impl;

import com.example.lombok.models.Plane;
import com.example.lombok.repository.PlaneRepository;
import com.example.lombok.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public void print() {
        System.out.println(planeRepository.getAll().toString());

    }

    @Override
    public void save(Plane plane) {
        planeRepository.save(plane);
    }
}
