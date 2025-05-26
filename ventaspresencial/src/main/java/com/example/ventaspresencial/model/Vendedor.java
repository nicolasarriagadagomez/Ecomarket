package com.example.ventaspresencial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedor {
    @Id
    private int idVenderdor;
    @Column(nullable = false, length = 15)
    private String vendedor;
    @Column (nullable = false)
    private char genero;
    @Column(nullable = false)
    private int fechaNacimiento;
}
