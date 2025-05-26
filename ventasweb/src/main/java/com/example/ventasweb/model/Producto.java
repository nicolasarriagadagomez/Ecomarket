package com.example.ventasweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private String unidadMedida;
    @Column(nullable = false)
    private double precio;
}