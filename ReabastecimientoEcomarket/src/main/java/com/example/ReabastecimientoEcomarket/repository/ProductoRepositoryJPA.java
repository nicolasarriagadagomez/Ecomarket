package com.example.ReabastecimientoEcomarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReabastecimientoEcomarket.model.Producto;

public interface ProductoRepositoryJPA extends JpaRepository<Producto, Integer> {

    Producto findById(int id);

    void deleteById(int id);
}
