package com.example.CatalogoEcoMarket.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.CatalogoEcoMarket.model.Producto;

@Repository
public class ProductoRepository {

    private List<Producto> listaProductos = new ArrayList<>();

    public List<Producto> obtenerProductos() {
        return listaProductos;
    }

    public Producto buscarPorId(int id) {
        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public Producto buscarPorCodigo(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null;
    }

    public Producto guardar(Producto prod) {
        listaProductos.add(prod);
        return prod;
    }

    public Producto actualizar(Producto prod) {
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
        Producto productoActualizado = new Producto();
        productoActualizado.setId(prod.getId());
        productoActualizado.setNombre(prod.getNombre());
        productoActualizado.setMarca(prod.getMarca());
        productoActualizado.setPrecio(prod.getPrecio());
        productoActualizado.setStock(prod.getStock());
        productoActualizado.setCodigo(prod.getCodigo());
        productoActualizado.setDescripcion(prod.getDescripcion());

        listaProductos.set(posicion, productoActualizado);
        return productoActualizado;
    }

    public void eliminar(int id) {
        Producto prod = buscarPorId(id);
        if (prod != null) {
            listaProductos.remove(prod);
        }
    }
}