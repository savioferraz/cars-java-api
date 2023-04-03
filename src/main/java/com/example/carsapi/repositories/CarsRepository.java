package com.example.carsapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.carsapi.models.Car;

@Repository
public interface CarsRepository extends JpaRepository<Car, Integer> {

}
