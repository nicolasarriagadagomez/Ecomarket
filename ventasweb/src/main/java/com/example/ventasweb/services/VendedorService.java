package com.example.ventasweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

import com.example.ventasweb.model.VendedorWeb;
import com.example.ventasweb.repository.VendedorWebRepositoryJPA;

@Service
@Transactional
public class VendedorService {
    @Autowired
    private VendedorWebRepositoryJPA vendedorRepository;
    
    public List<VendedorWeb> getVendedores(){
        return vendedorRepository.findAll();
    }

    public VendedorWeb saveVendedor(VendedorWeb vendedor){
        return vendedorRepository.save(vendedor);
    }

    public VendedorWeb getIdVendedor(int idVenderdor){
        return vendedorRepository.findById(idVenderdor);
    }

    public VendedorWeb updateBoleta(VendedorWeb vendedor){
        return vendedorRepository.save(vendedor);
    }

    public String deleteVendedor(int idVenderdor){
        vendedorRepository.deleteById(idVenderdor);
        return "producto eliminado";
    }
}