package com.example.CatalogoEcoMarket.controller;

import com.example.CatalogoEcoMarket.model.TipoProducto;
import com.example.CatalogoEcoMarket.services.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v4/tipoproductos")
public class TipoProductoController {

    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping
    public ResponseEntity<List<TipoProducto>> listarTipoProductos() {
        List<TipoProducto> tipos = tipoProductoService.obtenerTiposProducto();
        if (tipos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipos);
    }

    @PostMapping
    public ResponseEntity<TipoProducto> agregarTipoProducto(@RequestBody TipoProducto tipoProducto) {
        TipoProducto nuevo = tipoProductoService.guardarTipoProducto(tipoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> obtenerPorId(@PathVariable int id) {
        TipoProducto tipo = tipoProductoService.obtenerTipoProductoPorId(id);
        if (tipo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProducto> actualizarTipoProducto(@PathVariable int id, @RequestBody TipoProducto tipoActualizado) {
        TipoProducto tipoExistente = tipoProductoService.obtenerTipoProductoPorId(id);
        if (tipoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        tipoExistente.setNombre(tipoActualizado.getNombre());
        tipoExistente.setDescripcion(tipoActualizado.getDescripcion());
        tipoExistente.setEstado(tipoActualizado.isEstado());
        tipoExistente.setStock(tipoActualizado.getStock());

        tipoProductoService.guardarTipoProducto(tipoExistente);
        return ResponseEntity.ok(tipoExistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTipoProducto(@PathVariable int id) {
        try {
            tipoProductoService.eliminarTipoProducto(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
