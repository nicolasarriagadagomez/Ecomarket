package com.example.CatalogoEcoMarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CatalogoEcoMarket.model.Producto;
import com.example.CatalogoEcoMarket.repository.ProductoRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepositoryJPA productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(int id) {
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public String deleteProducto(int id) {
        productoRepository.deleteById(id);
        return "Producto eliminado";
    }
}
