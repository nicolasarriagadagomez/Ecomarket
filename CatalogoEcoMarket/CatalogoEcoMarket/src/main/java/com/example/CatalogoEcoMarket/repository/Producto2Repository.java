package com.example.CatalogoEcoMarket.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.CatalogoEcoMarket.model.Producto2;

@Repository
public class Producto2Repository {

    private List<Producto2> listaProductos = new ArrayList<>();

    public List<Producto2> obtenerProductos() {
        return listaProductos;
    }

    public Producto2 buscarPorId(int id) {
        for (Producto2 producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public Producto2 buscarPorCodigo(String codigo) {
        for (Producto2 producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public Producto2 guardar(Producto2 prod) {
        listaProductos.add(prod);
        return prod;
    }

    public Producto2 actualizar(Producto2 prod) {
        int posicion = -1;
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getId() == prod.getId()) {
                posicion = i;
                break;
            }
        }
        if (posicion == -1) {
            return null; // no existe producto para actualizar
        }
        Producto2 productoActualizado = new Producto2();
        productoActualizado.setId(prod.getId());
        productoActualizado.setCodigo(prod.getCodigo());
        productoActualizado.setNombre(prod.getNombre());
        productoActualizado.setMarca(prod.getMarca());
        productoActualizado.setPrecio(prod.getPrecio());
        productoActualizado.setStock(prod.getStock());
        productoActualizado.setDescripcion(prod.getDescripcion());

        listaProductos.set(posicion, productoActualizado);
        return productoActualizado;
    }

    public void eliminar(int id) {
        Producto2 prod = buscarPorId(id);
        if (prod != null) {
            listaProductos.remove(prod);
        }
    }
}