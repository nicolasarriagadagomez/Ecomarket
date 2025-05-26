package com.example.CatalogoEcoMarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CatalogoEcoMarket.model.Producto4;

public interface Producto4RepositoryJPA extends JpaRepository<Producto4, Integer> {

    Producto4 findById(int id);
    Producto4 save(int id);
    void deleteById(int id);

    
}
