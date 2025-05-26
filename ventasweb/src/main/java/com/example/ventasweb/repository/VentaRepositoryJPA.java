package com.example.ventasweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ventasweb.model.Venta;

public interface VentaRepositoryJPA extends JpaRepository<Venta, Integer>{
    Venta findById(int idVenta);

    void deleteById(int idVenta);
}
