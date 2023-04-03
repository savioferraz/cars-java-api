package com.example.carsapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.example.carsapi.DTO.CarDTO;
import com.example.carsapi.models.Carros;
import com.example.carsapi.repositories.CarsRepository;

@RestController
@RequestMapping("/cars")

public class CarsController {

    @Autowired
    private CarsRepository repository;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void registerCar(@RequestBody @Valid CarDTO req) {
        repository.save(new Carros(req));
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Carros> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Carros> findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCar(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateCar(@PathVariable int id, @RequestBody @Valid CarDTO req) {
        repository.findById(id).map(car -> {
            car.setNome(req.nome());
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setDataFabricacao(req.dataFabricacao());
            car.setValor(req.valor());
            car.setAnoModelo(req.anoModelo());
            return repository.save(car);
        });
    }
}
