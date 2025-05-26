package com.example.ventasweb.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.example.ventasweb.model.Producto;
import com.example.ventasweb.services.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")
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
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PutMapping("{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto prod) {
        try {
            Producto producto = productoService.getProductoById(id);
            if (producto == null) {
                return ResponseEntity.notFound().build();
            }

            Producto producto1 = new Producto();
            producto1.setId(id);
            producto1.setNombre(prod.getNombre());
            producto1.setCategoria(prod.getCategoria());
            producto1.setStock(prod.getStock());
            producto1.setUnidadMedida(prod.getUnidadMedida());
            producto1.setPrecio(prod.getPrecio());

            productoService.saveProducto(producto);
            return ResponseEntity.ok(producto);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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