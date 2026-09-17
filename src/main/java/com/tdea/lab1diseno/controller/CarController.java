package com.tdea.lab1diseno.controller;

import com.tdea.lab1diseno.entity.Car;
import com.tdea.lab1diseno.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CarController {
@Autowired
    private CarRepository repository;

@GetMapping("/cool-cars")
    public Collection<Car> coolCars() {
    return repository.findAll()
            .stream()
            .filter(this::isCool)
            .collect(Collectors.toList());
}

private boolean isCool(Car car) {
    return !car.getName().equals("AMC Gremlin") &&
            !car.getName().equals("Triumph Stag") &&
            !car.getName().equals("Ford Pinto") &&
            !car.getName().equals("Yugo GV");
}

}
