package com.example.CatalogoEcoMarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.CatalogoEcoMarket.model.Producto2;

public interface Producto2RepositoryJPA extends JpaRepository<Producto2, Integer> {

    Producto2 findById(int id);
    Producto2 save(int id);
    
    void deleteById(int id);

    
}
