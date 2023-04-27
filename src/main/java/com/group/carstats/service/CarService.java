package com.group.carstats.service;

import com.group.carstats.model.Car;

import java.util.List;

public interface CarService {

    Car save(Car car);

    Car update(Car car, Long id);

    Car findById(Long id);

    void deleteById(Long id);

    List<Car> findALl();
}
