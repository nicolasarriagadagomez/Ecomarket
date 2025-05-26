package com.example.ventasweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ventasweb.model.VendedorWeb;

public interface VendedorWebRepositoryJPA extends JpaRepository<VendedorWeb, Integer>{
    VendedorWeb findById(int idBoleta);

    void deleteById(int idBoleta);
}