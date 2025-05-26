package com.example.ReabastecimientoEcomarket.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ReabastecimientoEcomarket.model.DetalleReabastecimiento;
import com.example.ReabastecimientoEcomarket.service.DetalleReabastecimientoService;

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
@RequestMapping("/api/v1/detallereabastecimientos")
public class DetalleReabastecimientoController {
    @Autowired
    private DetalleReabastecimientoService detalleReabastecimientoService;

    @GetMapping
    public ResponseEntity<List<DetalleReabastecimiento>> listarDetalleReabastecimiento() {
        List<DetalleReabastecimiento> detallereabastecimientos = detalleReabastecimientoService.getDetalleReabastecimientos();
        if (detallereabastecimientos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detallereabastecimientos);
    }

    @PostMapping
    public ResponseEntity<DetalleReabastecimiento> agregarDetalleReabastecimiento(@RequestBody DetalleReabastecimiento dr) {
        DetalleReabastecimiento detallereabastecimiento = detalleReabastecimientoService.saveDetalleReabastecimiento(dr);
        return ResponseEntity.status(HttpStatus.CREATED).body(detallereabastecimiento);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalleReabastecimiento> buscaDetalleReabastecimiento(@PathVariable int id) {
        DetalleReabastecimiento detallereabastecimiento = detalleReabastecimientoService.getDetalleReabastecimientoById(id);
        if (detallereabastecimiento != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detallereabastecimiento);
    }

    @PutMapping("{id}")
    public ResponseEntity<DetalleReabastecimiento> actualizarDetalleReabastecimiento(@PathVariable int id, @RequestBody DetalleReabastecimiento dr) {
        try{
            DetalleReabastecimiento detallereabastecimiento = detalleReabastecimientoService.getDetalleReabastecimientoById(id);
            detallereabastecimiento.setIdReabastecimiento(dr.getIdReabastecimiento());
            detallereabastecimiento.setIdProducto(dr.getIdProducto());
            detallereabastecimiento.setCantidad(dr.getCantidad());
            detallereabastecimiento.setPrecioUnitario(dr.getPrecioUnitario());
            detallereabastecimiento.setSubtotal(dr.getSubtotal());

            detalleReabastecimientoService.saveDetalleReabastecimiento(detallereabastecimiento);
            return ResponseEntity.ok(detallereabastecimiento);
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarDetalleReabastecimiento(@PathVariable int id) {
        try{
            detalleReabastecimientoService.deleteDetalleReabastecimiento(id);
            return ResponseEntity.noContent().build();
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
    }
}
