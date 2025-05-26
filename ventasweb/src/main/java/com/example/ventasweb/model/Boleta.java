package com.example.ventasweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "boleta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boleta {
    @Id
    private int idBoleta;
    @Column(nullable = false)
    private int idVenta;
    @Column(nullable = false)
    private String nombreVendedor;
    @Column(nullable = false)
    private String producto;
    @Column(nullable = false, length = 100)
    private String detalle;
    @Column(nullable = false)
    private int total;
    @Column(nullable = false)
    private int fechaBoleta;
}
