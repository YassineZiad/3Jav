package org.example.rest;

import jakarta.validation.Valid;
import org.example.entities.Car;
import org.example.rest.mappers.CarMapper;
import org.example.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    public CarService service;

    @PostMapping("/create")
    public ResponseEntity createCar(@RequestBody @Valid Car car) {
        try {
            var newCar = service.createCar(car);
            return ResponseEntity.ok(CarMapper.toDto(car));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

}
