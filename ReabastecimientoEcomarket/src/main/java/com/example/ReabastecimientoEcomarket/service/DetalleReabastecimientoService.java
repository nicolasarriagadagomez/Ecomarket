package com.example.ReabastecimientoEcomarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReabastecimientoEcomarket.model.DetalleReabastecimiento;
import com.example.ReabastecimientoEcomarket.repository.DetalleReabastecimientoRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetalleReabastecimientoService {
    @Autowired
    private DetalleReabastecimientoRepositoryJPA detalleReabastecimientoRepository;

    public List<DetalleReabastecimiento> getDetalleReabastecimientos(){
        return detalleReabastecimientoRepository.findAll();
    }

    public DetalleReabastecimiento getDetalleReabastecimientoById(int id){
        return detalleReabastecimientoRepository.findById(id);
    }

    public DetalleReabastecimiento saveDetalleReabastecimiento(DetalleReabastecimiento dr){
        return detalleReabastecimientoRepository.save(dr);
    }

    public DetalleReabastecimiento updateDetalleReabastecimiento(DetalleReabastecimiento dr){
        return detalleReabastecimientoRepository.save(dr);
    }

    public String deleteDetalleReabastecimiento(int id){
        detalleReabastecimientoRepository.deleteById(id);
        return "DetalleReabastecimiento eliminado";
    }
}
