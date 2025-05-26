package com.example.CatalogoEcoMarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CatalogoEcoMarket.model.Producto3;

public interface Producto3RepositoryJPA extends JpaRepository<Producto3, Integer> {

    Producto3 findById(int id);
    Producto3 save(int id);
    void deleteById(int id);

    
}
