package com.example.ventasweb.repository;

import com.example.ventasweb.model.Boleta;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoletaRepository {
    private List<Boleta> listaBoletas = new ArrayList<>();

    public List<Boleta> obtenerVentas(){
        return listaBoletas;
    }

    public Boleta buscarPorId(int id){
        for (Boleta boleta : listaBoletas) {
            if(boleta.getIdBoleta()==id){
                return boleta;
            }
        }
        return null;
    }

    public Boleta buscarPorVendedor(String vendedor){
        for (Boleta boleta : listaBoletas) {
            if(boleta.getNombreVendedor()== vendedor){
                return boleta;
            }
        }return null;
    }

    public Boleta guardar(Boleta bol){
        listaBoletas.add(bol);
        return bol;
    }

    public Boleta actualizar(Boleta bol){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaBoletas.size(); i++) {
            if ((listaBoletas.get(i).getIdVenta() == bol.getIdVenta())) {
                id = bol.getIdVenta();
                idPosicion = 1;
            }
        }

        Boleta boleta1 = new Boleta();
        boleta1.setIdBoleta(id);
        boleta1.setIdVenta(bol.getIdVenta());
        boleta1.setProducto(bol.getProducto());
        boleta1.setDetalle(bol.getDetalle());
        boleta1.setTotal(bol.getTotal());
        boleta1.setFechaBoleta(bol.getFechaBoleta());

        listaBoletas.set(idPosicion, boleta1);
        return boleta1;
    }

    public void eliminar(int id){
        Boleta boleta = buscarPorId(id);
        if (boleta != null) {
            listaBoletas.remove(boleta);
        }
    }
}