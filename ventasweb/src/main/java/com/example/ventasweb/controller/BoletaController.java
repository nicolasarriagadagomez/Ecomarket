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

import com.example.ventasweb.model.Boleta;
import com.example.ventasweb.services.BoletaService;

@RestController
@RequestMapping("/ap1/v1/Boletas")
public class BoletaController {
    
    @Autowired
    private BoletaService boletaService;

    @GetMapping
    public ResponseEntity <List<Boleta>> listaBoleta(){
        List <Boleta> boletas = boletaService.getBoletas();
        if(boletas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(boletas);
    }
    
    @PostMapping
    private ResponseEntity<Boleta> agregarBoleta(@RequestBody Boleta boleta){
        Boleta bol = boletaService.saveBoleta(boleta);
        return ResponseEntity.status(HttpStatus.CREATED).body(bol);
    }
    

    @GetMapping("{id}")
    public ResponseEntity <Boleta> buscarBoleta(@PathVariable int idBoleta){
        Boleta bol = boletaService.getIdBoleta(idBoleta);
        if(bol != null){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(bol);
    }
    
    @PutMapping("{id}")
    public ResponseEntity <Boleta> actualizarBoleta(@PathVariable int idBoleta, @RequestBody Boleta bol){
        try {
            Boleta boleta= boletaService.getIdBoleta(idBoleta);
            boleta.setIdBoleta(bol.getIdBoleta());
            boleta.setIdVenta(bol.getIdVenta());
            boleta.setProducto(bol.getProducto());
            boleta.setDetalle(bol.getDetalle());
            boleta.setTotal(bol.getTotal());
            boleta.setFechaBoleta(bol.getFechaBoleta());
            
            boletaService.saveBoleta(boleta);
            return ResponseEntity.ok(boleta);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity <?> eliminarBoleta(@PathVariable int idBoleta){
        try {
            boletaService.deleteBoleta(idBoleta);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}