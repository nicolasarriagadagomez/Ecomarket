package com.example.ventasweb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vendedorWeb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendedorWeb {
    @Id
    private int idVenderdor;
    @Column(nullable = false, length = 15)
    private String vendedor;
}
