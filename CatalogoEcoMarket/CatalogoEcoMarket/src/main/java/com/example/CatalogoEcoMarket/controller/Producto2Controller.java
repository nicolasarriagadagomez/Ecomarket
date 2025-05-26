package com.example.CatalogoEcoMarket.controller;

import com.example.CatalogoEcoMarket.model.Producto2;
import com.example.CatalogoEcoMarket.services.Producto2Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4/productos2")
public class Producto2Controller {

    @Autowired
    private Producto2Service producto2Service;

    @GetMapping
    public ResponseEntity<List<Producto2>> listarProductos() {
        List<Producto2> productos = producto2Service.getProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto2> agregarProducto(@RequestBody Producto2 prod) {
        Producto2 producto = producto2Service.saveProducto(prod);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Producto2> buscarProducto(@PathVariable int id) {
        Producto2 producto = producto2Service.getProductoById(id);
        if (producto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Producto2> actualizarProducto(@PathVariable int id, @RequestBody Producto2 prod) {
        try {
            Producto2 producto = producto2Service.getProductoById(id);
            producto.setId(prod.getId());
            producto.setNombre(prod.getNombre());
            producto.setMarca(prod.getMarca());
            producto.setPrecio(prod.getPrecio());
            producto.setStock(prod.getStock());
            producto.setCodigo(prod.getCodigo());
            producto.setDescripcion(prod.getDescripcion());

            producto2Service.saveProducto(producto);
            return ResponseEntity.ok(producto);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        try {
            producto2Service.deleteProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
