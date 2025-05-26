package com.example.ventaspresencial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ventaspresencial.model.Boleta;

@Repository
public interface BoletaRepositoryJPA extends JpaRepository<Boleta, Integer>{
    Boleta findById(int idBoleta);

    void deleteById(int idBoleta);
}