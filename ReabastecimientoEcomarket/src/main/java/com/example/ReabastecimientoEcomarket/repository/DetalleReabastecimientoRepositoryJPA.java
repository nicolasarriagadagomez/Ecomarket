package com.example.ReabastecimientoEcomarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReabastecimientoEcomarket.model.DetalleReabastecimiento;

public interface DetalleReabastecimientoRepositoryJPA extends JpaRepository<DetalleReabastecimiento, Integer> {

    DetalleReabastecimiento findById(int id);

    void deleteById(int id);
}
