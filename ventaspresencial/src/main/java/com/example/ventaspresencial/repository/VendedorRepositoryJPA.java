package com.example.ventaspresencial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ventaspresencial.model.Vendedor;

@Repository
public interface VendedorRepositoryJPA extends JpaRepository<Vendedor, Integer>{
    Vendedor findById(int idVenderdor);

    void deleteById(int idVenderdor);
}