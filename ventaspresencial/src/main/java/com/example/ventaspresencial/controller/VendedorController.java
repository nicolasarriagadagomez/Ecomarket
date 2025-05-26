package com.example.ventaspresencial.controller;

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

import com.example.ventaspresencial.model.Vendedor;
import com.example.ventaspresencial.services.VendedorService;

@RestController
@RequestMapping("/ap1/v1/Vendedores")
public class VendedorController {
    
    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity <List<Vendedor>> listaVendedor(){
        List <Vendedor> vendedores = vendedorService.getVendedores();
        if(vendedores.isEmpty()){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(vendedores);
    }
    
    @PostMapping
    private ResponseEntity<Vendedor> agregarVendedor(@RequestBody Vendedor vendedor){
        Vendedor vended = vendedorService.saveVendedor(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(vended);
    }
    

    @GetMapping("{idVenderdor}")
    public ResponseEntity <Vendedor> buscarVendedor(@PathVariable int idVenderdor){
        try {
            Vendedor vended = vendedorService.getIdVendedor(idVenderdor);
            return ResponseEntity.ok(vended);
        } catch (Exception ex){
            return ResponseEntity.noContent().build();
            }     
        }
    
    @PutMapping("{idVenderdor}")
    public ResponseEntity <Vendedor> actualizarVendedor(@PathVariable int idVenderdor, @RequestBody Vendedor vended){
        try {
            Vendedor vendedor1= vendedorService.getIdVendedor(idVenderdor);
            vendedor1.setIdVenderdor(vended.getIdVenderdor());
            vendedor1.setVendedor(vended.getVendedor());
            vendedor1.setGenero(vended.getGenero());
            vendedor1.setFechaNacimiento(vended.getFechaNacimiento());
            
            vendedorService.saveVendedor(vendedor1);
            return ResponseEntity.ok(vendedor1);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{idVenderdor}")
    public ResponseEntity <?> eliminarVendedor(@PathVariable int idVenderdor){
        try {
            vendedorService.deleteVendedor(idVenderdor);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}