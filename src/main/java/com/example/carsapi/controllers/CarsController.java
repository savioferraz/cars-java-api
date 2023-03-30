package com.example.carsapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carsapi.DTO.CarDTO;
import com.example.carsapi.models.Carros;
import com.example.carsapi.repositories.CarsRepository;

@RestController
@RequestMapping("/cars")

public class CarsController {

    @Autowired
    private CarsRepository repository;

    @PostMapping
    public void registerCar(@RequestBody CarDTO req) {
        repository.save(new Carros(req));
        System.out.println("Carro " + req.nome() + " criado com sucesso");
    }

    @GetMapping
    public void findAll() {
        repository.findAll();

    }
}
