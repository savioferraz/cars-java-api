package com.example.carsapi.models;

import com.example.carsapi.DTO.CarDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Carros {

    public Carros(CarDTO req) {
        this.nome = req.nome();
        this.modelo = req.modelo();
        this.fabricante = req.dataFabricacao();
        this.dataFabricacao = req.dataFabricacao();
        this.valor = req.valor();
        this.anoModelo = req.anoModelo();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Modelo modelo;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private String dataFabricacao;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int anoModelo;
}
