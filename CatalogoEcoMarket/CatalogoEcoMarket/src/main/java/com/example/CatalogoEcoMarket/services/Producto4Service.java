package com.example.CatalogoEcoMarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CatalogoEcoMarket.model.Producto4;
import com.example.CatalogoEcoMarket.repository.Producto4RepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Producto4Service {
    @Autowired
    private Producto4RepositoryJPA productoRepository;

    public List<Producto4> getProductos() {
        return productoRepository.findAll();
    }

    public Producto4 getProductoById(int id) {
        return productoRepository.findById(id);
    }

    public Producto4 saveProducto(Producto4 producto) {
        return productoRepository.save(producto);
    }

    public Producto4 updateProducto(Producto4 producto) {
        return productoRepository.save(producto);
    }

    public String deleteProducto(int id) {
        productoRepository.deleteById(id);
        return "Producto eliminado";
    }
}
