package com.example.ventasweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

import com.example.ventasweb.model.Boleta;
import com.example.ventasweb.repository.BoletaRepositoryJPA;

@Service
@Transactional
public class BoletaService {
    @Autowired
    private BoletaRepositoryJPA boletaRepository;
    
    public List<Boleta> getBoletas(){
        return boletaRepository.findAll();
    }

    public Boleta saveBoleta(Boleta boleta){
        return boletaRepository.save(boleta);
    }

    public Boleta getIdBoleta(int idBoleta){
        return boletaRepository.findById(idBoleta);
    }

    public Boleta updateBoleta(Boleta boleta){
        return boletaRepository.save(boleta);
    }

    public String deleteBoleta(int idBoleta){
        boletaRepository.deleteById(idBoleta);
        return "producto eliminado";
    }
}