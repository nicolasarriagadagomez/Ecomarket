package com.example.ReabastecimientoEcomarket.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReabastecimientoEcomarket.model.Empleado;



public interface EmpleadoRepositoryJPA extends JpaRepository<Empleado, Integer> {

    Empleado findById(int id);

    void deleteById(int id);
}
