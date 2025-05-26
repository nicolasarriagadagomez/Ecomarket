package com.example.ReabastecimientoEcomarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String cargo;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String telefono;
}
