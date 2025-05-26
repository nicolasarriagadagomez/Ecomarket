package com.example.ventaspresencial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ventaspresencial.model.Venta;

@Repository
public interface VentaRepositoryJPA extends JpaRepository<Venta, Integer>{
    Venta findById(int idVenta);

    void deleteById(int idVenta);
}
