package com.example.ReabastecimientoEcomarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_reabastecimiento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleReabastecimiento {
    @Id
    private int id;
    @Column(nullable = false)
    private int idReabastecimiento;
    @Column(nullable = false)
    private int idProducto;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double precioUnitario;
    @Column(nullable = false)
    private double subtotal;
}
