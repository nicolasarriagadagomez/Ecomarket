package com.example.CatalogoEcoMarket.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.CatalogoEcoMarket.model.Producto4;
import com.example.CatalogoEcoMarket.services.Producto4Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4/productos4")
public class Producto4Controller {

    @Autowired
    private Producto4Service producto4Service;

    @GetMapping
    public ResponseEntity<List<Producto4>> listarProductos() {
        List<Producto4> productos = producto4Service.getProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto4> agregarProducto(@RequestBody Producto4 prod) {
        Producto4 producto = producto4Service.saveProducto(prod);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Producto4> buscarProducto(@PathVariable int id) {
        Producto4 producto = producto4Service.getProductoById(id);
        if (producto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Producto4> actualizarProducto(@PathVariable int id, @RequestBody Producto4 prod) {
        try {
            Producto4 producto = producto4Service.getProductoById(id);
            producto.setNombre(prod.getNombre());
            producto.setDescripcion(prod.getDescripcion());
            producto.setPrecio(prod.getPrecio());
            producto.setStock(prod.getStock());
            producto.setCodigo(prod.getCodigo());
            producto.setMarca(prod.getMarca());

            producto4Service.saveProducto(producto);
            return ResponseEntity.ok(producto);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        try {
            producto4Service.deleteProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
