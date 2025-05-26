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

import com.example.ventasweb.model.VendedorWeb;
import com.example.ventasweb.services.VendedorService;

@RestController
@RequestMapping("/ap1/v1/Vendedor")
public class VendedorWebController {
    
    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity <List<VendedorWeb>> listaVendedor(){
        List <VendedorWeb> vendedores = vendedorService.getVendedores();
        if(vendedores.isEmpty()){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(vendedores);
    }
    
    @PostMapping
    private ResponseEntity<VendedorWeb> agregarVendedor(@RequestBody VendedorWeb vendedor){
        VendedorWeb vended = vendedorService.saveVendedor(vendedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(vended);
    }
    

    @GetMapping("{id}")
    public ResponseEntity <VendedorWeb> buscarVendedor(@PathVariable int idVenderdor){
        VendedorWeb vended = vendedorService.getIdVendedor(idVenderdor);
        if(vended != null){
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.ok(vended);
    }
    
    @PutMapping("{id}")
    public ResponseEntity <VendedorWeb> actualizarVendedor(@PathVariable int idVenderdor, @RequestBody VendedorWeb vended){
        try {
            VendedorWeb vendedor1= vendedorService.getIdVendedor(idVenderdor);
            vendedor1.setIdVenderdor(vended.getIdVenderdor());
            vendedor1.setVendedor(vended.getVendedor());
            
            vendedorService.saveVendedor(vendedor1);
            return ResponseEntity.ok(vendedor1);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity <?> eliminarVendedor(@PathVariable int idVenderdor){
        try {
            vendedorService.deleteVendedor(idVenderdor);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}