package com.example.taskscheduling.services;

import com.example.taskscheduling.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    void save(Car car);

    void updateCarAgeJob();
}
