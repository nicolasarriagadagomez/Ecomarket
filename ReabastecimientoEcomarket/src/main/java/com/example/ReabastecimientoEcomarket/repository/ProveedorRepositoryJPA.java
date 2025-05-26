package com.example.ReabastecimientoEcomarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReabastecimientoEcomarket.model.Proveedor;

public interface ProveedorRepositoryJPA extends JpaRepository<Proveedor, Integer> {

    Proveedor findById(int id);

    void deleteById(int id);
}
