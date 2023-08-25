package com.example.taskscheduling.services;

import com.example.taskscheduling.entities.Car;
import com.example.taskscheduling.repos.CarRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

@Service
@Repository
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Car> findAll() {
        return Lists.newArrayList(carRepository.findAll());
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    @Scheduled(fixedDelay = 10000)
    public void updateCarAgeJob() {
        List<Car> cars = findAll();
        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println("Car age update job started");
        cars.forEach(car -> {
            int age = Period.between(LocalDate.from(car.getManufacturerDate()), currentDate.toLocalDate()).getYears();
            car.setAge(age);
            save(car);
            System.out.println("Car age update--> " + car);
        });
        System.out.println("Car age update job completed successfully");
    }
}
