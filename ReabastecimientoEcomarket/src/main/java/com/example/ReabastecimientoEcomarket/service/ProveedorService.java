package com.example.ReabastecimientoEcomarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReabastecimientoEcomarket.model.Proveedor;
import com.example.ReabastecimientoEcomarket.repository.ProveedorRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProveedorService {
    @Autowired
    private ProveedorRepositoryJPA proveedorRepository;

    public List<Proveedor> getProveedores(){
        return proveedorRepository.findAll();
    }

    public Proveedor getProveedorById(int id){
        return proveedorRepository.findById(id);
    }

    public Proveedor saveProveedor(Proveedor prov){
        return proveedorRepository.save(prov);
    }

    public Proveedor updateProveedor(Proveedor prov){
        return proveedorRepository.save(prov);
    }

    public String deleteProveedor(int id){
        proveedorRepository.deleteById(id);
        return "Proveedor eliminado";
    }
}
