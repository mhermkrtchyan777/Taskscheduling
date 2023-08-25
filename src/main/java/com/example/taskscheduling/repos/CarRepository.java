package com.example.taskscheduling.repos;

import com.example.taskscheduling.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
