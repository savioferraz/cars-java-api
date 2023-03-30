package com.example.carsapi.DTO;

import com.example.carsapi.models.Modelo;

public record CarDTO(
        String nome,
        Modelo modelo,
        String fabricante,
        String dataFabricacao,
        double valor,
        int anoModelo) {

}
