package com.example.ReabastecimientoEcomarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
    @Id
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String contacto;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String ruc;
}
