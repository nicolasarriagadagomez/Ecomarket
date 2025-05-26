package com.example.CatalogoEcoMarket.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.CatalogoEcoMarket.model.TipoProducto;

@Repository
public class TipoProductoRepository {

    private List<TipoProducto> listaTipoProductos = new ArrayList<>();

    public List<TipoProducto> obtenerTipoProductos() {
        return listaTipoProductos;
    }

    public TipoProducto buscarPorId(int id) {
        for (TipoProducto tipo : listaTipoProductos) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        return null;
    }

    public TipoProducto guardar(TipoProducto tipo) {
        listaTipoProductos.add(tipo);
        return tipo;
    }

    public TipoProducto actualizar(TipoProducto tipo) {
        int posicion = -1;
        for (int i = 0; i < listaTipoProductos.size(); i++) {
            if (listaTipoProductos.get(i).getId() == tipo.getId()) {
                posicion = i;
                break;
            }
        }
        if (posicion != -1) {
            listaTipoProductos.set(posicion, tipo);
            return tipo;
        }
        return null;
    }

    public void eliminar(int id) {
        TipoProducto tipo = buscarPorId(id);
        if (tipo != null) {
            listaTipoProductos.remove(tipo);
        }
    }
}
