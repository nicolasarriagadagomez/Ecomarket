package com.example.ventasweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

import com.example.ventasweb.model.Venta;
import com.example.ventasweb.repository.VentaRepositoryJPA;

@Service
@Transactional
public class VentaService {
    @Autowired
    private VentaRepositoryJPA ventaRepository;
    
    public List<Venta> getVentas(){
        return ventaRepository.findAll();
    }

    public Venta saveVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    public Venta getIdVenta(int idVenta){
        return ventaRepository.findById(idVenta);
    }

    public Venta updateVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    public String deleteVenta(int id){
        ventaRepository.deleteById(id);
        return "producto eliminado";
    }
}
