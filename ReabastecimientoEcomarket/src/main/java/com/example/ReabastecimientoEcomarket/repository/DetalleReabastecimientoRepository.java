package com.example.ReabastecimientoEcomarket.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ReabastecimientoEcomarket.model.DetalleReabastecimiento;

@Repository
public class DetalleReabastecimientoRepository {

    private List<DetalleReabastecimiento> listaDetalleReabastecimientos = new ArrayList<>();

    public List<DetalleReabastecimiento> obtenerDetalleReabastecimientos(){
        return listaDetalleReabastecimientos;
    }

    public DetalleReabastecimiento buscarPorId(int id){
        for (DetalleReabastecimiento dr : listaDetalleReabastecimientos) {
            if (dr.getId()==id) {
                return dr;
            }
        }
        return null;
    }

    public DetalleReabastecimiento guardar(DetalleReabastecimiento dr){
        listaDetalleReabastecimientos.add(dr);
        return dr;
    }

    public DetalleReabastecimiento actualizar(DetalleReabastecimiento dr){
        int id=0;
        int posicion=0;
        for (int i = 0; i < listaDetalleReabastecimientos.size(); i++) {
            if(listaDetalleReabastecimientos.get(i).getId()==dr.getId()){
                id= dr.getId();
                posicion=i;
            }
        }
        DetalleReabastecimiento detalle = new DetalleReabastecimiento();
        detalle.setIdReabastecimiento(id);
        detalle.setIdProducto(dr.getIdProducto());
        detalle.setCantidad(dr.getCantidad());
        detalle.setPrecioUnitario(dr.getPrecioUnitario());
        detalle.setSubtotal(dr.getSubtotal());

        listaDetalleReabastecimientos.set(posicion, detalle);
        return detalle;
    }

    public void eliminar(int id){
        DetalleReabastecimiento dr = buscarPorId(id);
        if (dr!=null) {
            listaDetalleReabastecimientos.remove(dr);
        }
    }
}
