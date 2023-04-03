package com.example.carsapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carsapi.DTO.CarDTO;
import com.example.carsapi.models.Car;
import com.example.carsapi.repositories.CarsRepository;

@Service
public class CarsService {

    @Autowired
    private CarsRepository repository;

    public void createCar(Car data) {
        repository.save(data);
    }

    public List<Car> findAllCars() {
        return repository.findAll();
    }

    public Optional<Car> findCarById(int id) {
        return repository.findById(id);
    }

    public void deleteCar(int id) {
        repository.deleteById(id);

    }

    public void updateCar(int id, CarDTO data) {
        repository.findById(id).map(car -> {
            car.setNome(data.nome());
            car.setModelo(data.modelo());
            car.setFabricante(data.fabricante());
            car.setDataFabricacao(data.dataFabricacao());
            car.setValor(data.valor());
            car.setAnoModelo(data.anoModelo());
            return repository.save(car);
        });
    }

}
