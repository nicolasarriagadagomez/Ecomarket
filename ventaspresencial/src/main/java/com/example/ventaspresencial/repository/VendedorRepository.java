package com.example.ventaspresencial.repository;

import com.example.ventaspresencial.model.Vendedor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VendedorRepository {
    private List<Vendedor> listaVendedores = new ArrayList<>();

    public List<Vendedor> obtenerVendedores(){
        return listaVendedores;
    }

    public Vendedor buscarPorId(int id){
        for (Vendedor vendedor : listaVendedores) {
            if(vendedor.getIdVenderdor()==id){
                return vendedor;
            }
        }
        return null;
    }

    public Vendedor buscarPorVendedor(String vendedor){
        for (Vendedor vend : listaVendedores) {
            if(vend.getVendedor().equals(vendedor)){
                return vend;
            }
        }return null;
    }

    public Vendedor guardar(Vendedor ven){
        listaVendedores.add(ven);
        return ven;
    }

    public Vendedor actualizar(Vendedor ven){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaVendedores.size(); i++) {
            if ((listaVendedores.get(i).getVendedor() == ven.getVendedor())) {
                id = ven.getIdVenderdor();
                idPosicion = 1;
            }
        }

        Vendedor vendedor1 = new Vendedor();
        vendedor1.setIdVenderdor(id);
        vendedor1.setVendedor(ven.getVendedor());;
        vendedor1.setGenero(ven.getGenero());
        vendedor1.setFechaNacimiento(ven.getFechaNacimiento());

        listaVendedores.set(idPosicion, vendedor1);
        return vendedor1;
    }

    public void eliminar(int id){
        Vendedor vendedor = buscarPorId(id);
        if (vendedor != null) {
            listaVendedores.remove(vendedor);
        }
    }
}