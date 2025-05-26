package com.example.ventaspresencial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

import com.example.ventaspresencial.model.Vendedor;
import com.example.ventaspresencial.repository.VendedorRepositoryJPA;

@Service
@Transactional
public class VendedorService {
    @Autowired
    private VendedorRepositoryJPA vendedorRepository;
    
    public List<Vendedor> getVendedores(){
        return vendedorRepository.findAll();
    }

    public Vendedor saveVendedor(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public Vendedor getIdVendedor(int idVenderdor){
        return vendedorRepository.findById(idVenderdor);
    }

    public Vendedor updateBoleta(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public String deleteVendedor(int idVenderdor){
        vendedorRepository.deleteById(idVenderdor);
        return "producto eliminado";
    }
}