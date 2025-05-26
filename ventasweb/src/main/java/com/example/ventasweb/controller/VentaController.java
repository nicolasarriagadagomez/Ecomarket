package com.example.ventasweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ventasweb.model.Venta;
import com.example.ventasweb.services.VentaService;

@RestController
@RequestMapping("/ap1/v1/Ventas")
public class VentaController {
    
    @Autowired
    private VentaService ventaService;

    @GetMapping
    public ResponseEntity <List<Venta>> listaVenta(){
        List <Venta> ventas = ventaService.getVentas();
        if(ventas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(ventas);
    }
    
    @PostMapping
    private ResponseEntity<Venta> agregarLibro(@RequestBody Venta venta){
        Venta vent = ventaService.saveVenta(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(vent);
    }
    

    @GetMapping("{id}")
    public ResponseEntity <Venta> buscarVenta(@PathVariable int idVenta){
        Venta venta = ventaService.getIdVenta(idVenta);
        if(venta != null){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(venta);
    }
    
    @PutMapping("{id}")
    public ResponseEntity <Venta> actualizarVenta(@PathVariable int idVenta, @RequestBody Venta vent){
        try {
            Venta venta= ventaService.getIdVenta(idVenta);
            venta.setComprador(vent.getComprador());
            venta.setIdComprador(vent.getIdComprador());
            venta.setVendedor(vent.getVendedor());
            venta.setIdVendedor(vent.getIdVendedor());
            venta.setTotal(vent.getTotal());
            venta.setFechaVenta(vent.getFechaVenta());
            
            ventaService.saveVenta(venta);
            return ResponseEntity.ok(venta);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity <?> eliminarLibro(@PathVariable int idVenta){
        try {
            ventaService.deleteVenta(idVenta);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
