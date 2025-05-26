package com.example.CatalogoEcoMarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CatalogoEcoMarket.model.Producto;

public interface ProductoRepositoryJPA extends JpaRepository<Producto, Integer> {

    Producto findById(int id);
    Producto save(int id);
    void deleteById(int id);

    
}
