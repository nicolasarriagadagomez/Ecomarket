package com.example.ventasweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    private int idVenta;
    @Column(nullable = false, length = 15)
    private String comprador;
    @Column(nullable = false)
    private int idComprador;
    @Column(nullable = false, length = 15)
    private String vendedor;
    @Column(nullable = false)
    private int idVendedor;
    @Column(nullable = false)
    private int total;
    @Column(nullable = false)
    private int fechaVenta;
}
