package com.group.carstats.service.impl;

import com.group.carstats.exception.DuplicateEntryException;
import com.group.carstats.exception.ResourceNotFoundException;
import com.group.carstats.model.Car;
import com.group.carstats.repository.CarRepository;
import com.group.carstats.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        try {
            return carRepository.save(car);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEntryException("Car already exists.");
        }
    }

    @Override
    public Car update(Car car, Long id) {
        Car foundCar = findById(id);
        Car updatedCar = Car.builder()
                .id(foundCar.getId())
                .build();

        return carRepository.save(updatedCar);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Car with id: %d does not exist.", id)));
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findALl() {
        return carRepository.findAll();
    }
}
