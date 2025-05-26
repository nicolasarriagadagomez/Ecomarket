package com.example.ReabastecimientoEcomarket.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ReabastecimientoEcomarket.model.Proveedor;

@Repository
public class ProveedorRepository {

    private List<Proveedor> listaProveedores = new ArrayList<>();

    public List<Proveedor> obtenerProveedores(){
        return listaProveedores;
    }

    public Proveedor buscarPorId(int id){
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getId()==id) {
                return proveedor;
            }
        }
        return null;
    }

    public Proveedor guardar(Proveedor prov){
        listaProveedores.add(prov);
        return prov;
    }

    public Proveedor actualizar(Proveedor prov){
        int id=0;
        int posicion=0;
        for (int i = 0; i < listaProveedores.size(); i++) {
            if(listaProveedores.get(i).getId()==prov.getId()){
                id= prov.getId();
                posicion=i;
            }
        }
        Proveedor proveedor1 = new Proveedor();
        proveedor1.setId(id);
        proveedor1.setNombre(prov.getNombre());
        proveedor1.setContacto(prov.getContacto());
        proveedor1.setDireccion(prov.getDireccion());
        proveedor1.setRuc(prov.getRuc());

        listaProveedores.set(posicion, proveedor1);
        return proveedor1;
    }

    public void eliminar(int id){
        Proveedor prov = buscarPorId(id);
        if (prov!=null) {
            listaProveedores.remove(prov);
        }
    }
}
