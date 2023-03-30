package com.example.carsapi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carsapi.DTO.CarDTO;

@RestController
@RequestMapping("/cars")

public class CarsController {

    @PostMapping
    public void registerCar(@RequestBody CarDTO req) {
        System.out.println(req);
    }
}
