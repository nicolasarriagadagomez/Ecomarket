package com.example.CatalogoEcoMarket.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.CatalogoEcoMarket.model.Producto;
import com.example.CatalogoEcoMarket.services.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = productoService.getProductos();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto prod) {
        Producto producto = productoService.saveProducto(prod);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable int id) {
        Producto producto = productoService.getProductoById(id);
        if (producto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto prod) {
        try {
            Producto producto = productoService.getProductoById(id);
            producto.setNombre(prod.getNombre());
            producto.setDescripcion(prod.getDescripcion());
            producto.setPrecio(prod.getPrecio());
            producto.setStock(prod.getStock());
            producto.setCodigo(prod.getCodigo());
            producto.setMarca(prod.getMarca());

            productoService.saveProducto(producto);
            return ResponseEntity.ok(producto);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
        try {
            productoService.deleteProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
