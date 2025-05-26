package com.example.CatalogoEcoMarket.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.CatalogoEcoMarket.model.Producto3;
import com.example.CatalogoEcoMarket.services.Producto3Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4/productos3")
public class Producto3Controller {

    @Autowired
    private Producto3Service producto3Service;

    @GetMapping
    public ResponseEntity<List<Producto3>> listarProductos() {
        List<Producto3> productos = producto3Service.getProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto3> agregarProducto(@RequestBody Producto3 prod) {
        Producto3 producto = producto3Service.saveProducto(prod);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Producto3> buscarProducto(@PathVariable int id) {
        Producto3 producto = producto3Service.getProductoById(id);
        if (producto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Producto3> actualizarProducto(@PathVariable int id, @RequestBody Producto3 prod) {
        try {
            Producto3 producto = producto3Service.getProductoById(id);
            producto.setNombre(prod.getNombre());
            producto.setDescripcion(prod.getDescripcion());
            producto.setPrecio(prod.getPrecio());
            producto.setStock(prod.getStock());
            producto.setCodigo(prod.getCodigo());
            producto.setMarca(prod.getMarca());

            producto3Service.saveProducto(producto);
            return ResponseEntity.ok(producto);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        try {
            producto3Service.deleteProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
