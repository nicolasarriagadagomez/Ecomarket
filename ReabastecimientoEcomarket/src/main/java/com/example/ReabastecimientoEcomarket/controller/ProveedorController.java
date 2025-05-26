package com.example.ReabastecimientoEcomarket.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ReabastecimientoEcomarket.service.ProveedorService;
import com.example.ReabastecimientoEcomarket.model.Proveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedor() {
        List<Proveedor> proveedores = proveedorService.getProveedores();
        if (proveedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proveedores);
    }

    @PostMapping
    public ResponseEntity<Proveedor> agregarProveedor(@RequestBody Proveedor prov) {
        Proveedor proveedor = proveedorService.saveProveedor(prov);
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Proveedor> buscaProveedor(@PathVariable int id) {
        Proveedor proveedor = proveedorService.getProveedorById(id);
        if (proveedor != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proveedor);
    }

    @PutMapping("{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable int id, @RequestBody Proveedor prov) {
        try{
            Proveedor proveedor = proveedorService.getProveedorById(id);
            proveedor.setNombre(prov.getNombre());
            proveedor.setContacto(prov.getContacto());
            proveedor.setDireccion(prov.getDireccion());
            proveedor.setRuc(prov.getRuc());

            proveedorService.saveProveedor(proveedor);
            return ResponseEntity.ok(proveedor);
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable int id) {
        try{
            proveedorService.deleteProveedor(id);
            return ResponseEntity.noContent().build();
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
    }
}
