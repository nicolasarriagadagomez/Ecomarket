package com.example.CatalogoEcoMarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CatalogoEcoMarket.model.TipoProducto;

public interface TipoProductoRepositoryJPA extends JpaRepository<TipoProducto, Integer> {

    TipoProducto findById(int id);
    TipoProducto save(int id);
    void deleteById(int id);
}
