package com.example.ReabastecimientoEcomarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReabastecimientoEcomarket.model.Empleado;
import com.example.ReabastecimientoEcomarket.repository.EmpleadoRepositoryJPA;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmpleadoService {
    @Autowired
    private EmpleadoRepositoryJPA empleadoRepository;

    public List<Empleado> getEmpleados(){
        return empleadoRepository.findAll();
    }

    public Empleado getEmpleadoById(int id){
        return empleadoRepository.findById(id);
    }

    public Empleado saveEmpleado(Empleado emp){
        return empleadoRepository.save(emp);
    }

    public Empleado updateEmpleado(Empleado emp){
        return empleadoRepository.save(emp);
    }

    public String deleteEmpleado(int id){
        empleadoRepository.deleteById(id);
        return "Empleado eliminado";
    }
}
