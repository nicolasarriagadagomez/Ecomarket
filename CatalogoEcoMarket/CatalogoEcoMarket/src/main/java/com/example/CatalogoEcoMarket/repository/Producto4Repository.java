package com.example.CatalogoEcoMarket.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.CatalogoEcoMarket.model.Producto4;

@Repository
public class Producto4Repository {

    private List<Producto4> listaProductos = new ArrayList<>();

    public List<Producto4> obtenerProductos() {
        return listaProductos;
    }

    public Producto4 buscarPorId(int id) {
        for (Producto4 producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public Producto4 buscarPorCodigo(String codigo) {
        for (Producto4 producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public Producto4 guardar(Producto4 prod) {
        listaProductos.add(prod);
        return prod;
    }

    public Producto4 actualizar(Producto4 prod) {
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
        Producto4 productoActualizado = new Producto4();
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
        Producto4 prod = buscarPorId(id);
        if (prod != null) {
            listaProductos.remove(prod);
        }
    }
}