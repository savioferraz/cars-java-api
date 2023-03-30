package com.example.carsapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
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
        System.out.println("Carro " + req.nome() + " criado com sucesso");
    }

    @GetMapping
    public String getCars() {
        return "all ok here!";
    }
}
