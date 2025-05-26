package com.example.ventaspresencial.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ventaspresencial.model.Producto;

@Repository
public class ProductoRepository {

    private List<Producto> listaProductos = new ArrayList<>();

    public List<Producto> obtenerProductos(){
        return listaProductos;
    }

    public Producto buscarPorId(int id){
        for (Producto producto : listaProductos) {
            if (producto.getId()==id) {
                return producto;
            }
        }
        return null;
    }

    public Producto guardar(Producto prod){
        listaProductos.add(prod);
        return prod;
    }

    public Producto actualizar(Producto prod){
        int id=0;
        int posicion=0;
        for (int i = 0; i < listaProductos.size(); i++) {
            if(listaProductos.get(i).getId()==prod.getId()){
                id= prod.getId();
                posicion=i;
            }
        }
        Producto producto1 = new Producto();
        producto1.setId(id);
        producto1.setCodigo(prod.getCodigo());
        producto1.setNombre(prod.getNombre());
        producto1.setMarca(prod.getMarca());
        producto1.setPrecio(prod.getPrecio());
        producto1.setStock(prod.getStock());
        producto1.setDescripcion(prod.getDescripcion());

        listaProductos.set(posicion, producto1);
        return producto1;
    }

    public void eliminar(int id){
        Producto prod = buscarPorId(id);
        if (prod!=null) {
            listaProductos.remove(prod);
        }
    }
}
