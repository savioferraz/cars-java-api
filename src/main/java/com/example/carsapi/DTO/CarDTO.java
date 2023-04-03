package com.example.carsapi.DTO;

import com.example.carsapi.models.enums.Modelo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record CarDTO(

        @NotBlank(message = "Insira um nome válido") String nome,

        Modelo modelo,

        @NotBlank(message = "Insira um fabricante válido") String fabricante,

        @NotBlank(message = "Insira uma data no formato AAAA-MM-DD") String dataFabricacao,

        @Positive(message = "Insira um valor válido") double valor,

        @Min(value = 1900, message = "Insira um ano válido") @Max(value = 2023, message = "O ano de fabricação não pode ser superior que o ano atual") int anoModelo) {

}
