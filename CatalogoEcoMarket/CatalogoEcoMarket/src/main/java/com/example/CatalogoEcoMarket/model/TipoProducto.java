package com.example.CatalogoEcoMarket.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipoproducto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoProducto {
    @Id
    private int id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 255)
    private String descripcion;
    @Column(nullable = false)
    private boolean estado;
    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
    @Column(nullable = false)
    private int stock;
}
