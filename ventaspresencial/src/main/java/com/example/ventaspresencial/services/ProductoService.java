package com.example.ventaspresencial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ventaspresencial.model.Producto;
import com.example.ventaspresencial.repository.ProductoRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {
    @Autowired
    private ProductoRepositoryJPA productoRepository;

    public List<Producto> getProductos(){
        return productoRepository.findAll();
    }

    public Producto getProductoById(int id){
        return productoRepository.findById(id);
    }

    public Producto saveProducto(Producto prod){
        return productoRepository.save(prod);
    }

    public Producto updateProducto(Producto prod){
        return productoRepository.save(prod);
    }

    public String deleteProducto(int id){
        productoRepository.deleteById(id);
        return "Producto eliminado";
    }
}
