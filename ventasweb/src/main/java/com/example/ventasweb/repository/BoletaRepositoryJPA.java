package com.example.ventasweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ventasweb.model.Boleta;

public interface BoletaRepositoryJPA extends JpaRepository<Boleta, Integer>{
    Boleta findById(int idBoleta);

    void deleteById(int idBoleta);
}
