package com.example.ventasweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ventasweb.model.Producto;

public interface ProductoRepositoryJPA extends JpaRepository<Producto, Integer>{
    Producto findById(int id);

    void deleteById(int id);
}
