package com.example.CatalogoEcoMarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CatalogoEcoMarket.model.Producto2;
import com.example.CatalogoEcoMarket.repository.Producto2RepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Producto2Service {
    @Autowired
    private Producto2RepositoryJPA productoRepository;

    public List<Producto2> getProductos() {
        return productoRepository.findAll();
    }

    public Producto2 getProductoById(int id) {
        return productoRepository.findById(id);
    }

    public Producto2 saveProducto(Producto2 prod) {
        return productoRepository.save(prod);
    }

    public Producto2 updateProducto(Producto2 producto) {
        return productoRepository.save(producto);
    }

    public String deleteProducto(int id) {
        productoRepository.deleteById(id);
        return "Producto eliminado";
    }
}