package com.example.CatalogoEcoMarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CatalogoEcoMarket.model.Producto3;
import com.example.CatalogoEcoMarket.repository.Producto3RepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Producto3Service {
    @Autowired
    private Producto3RepositoryJPA productoRepository;

    public List<Producto3> getProductos() {
        return productoRepository.findAll();
    }

    public Producto3 getProductoById(int id) {
        return productoRepository.findById(id);
    }

    public Producto3 saveProducto(Producto3 producto) {
        return productoRepository.save(producto);
    }

    public Producto3 updateProducto(Producto3 producto) {
        return productoRepository.save(producto);
    }

    public String deleteProducto(int id) {
        productoRepository.deleteById(id);
        return "Producto eliminado";
    }
}
