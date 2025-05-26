package com.example.ventasweb.repository;

import com.example.ventasweb.model.VendedorWeb;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VendedorWebRepository {
    private List<VendedorWeb> listaVendedores = new ArrayList<>();

    public List<VendedorWeb> obtenerVendedores(){
        return listaVendedores;
    }

    public VendedorWeb buscarPorId(int id){
        for (VendedorWeb vendedor : listaVendedores) {
            if(vendedor.getIdVenderdor()==id){
                return vendedor;
            }
        }
        return null;
    }

    public VendedorWeb buscarPorVendedor(String vendedor){
        for (VendedorWeb vend : listaVendedores) {
            if(vend.getVendedor().equals(vendedor)){
                return vend;
            }
        }return null;
    }

    public VendedorWeb guardar(VendedorWeb ven){
        if(listaVendedores.size()<1){
            listaVendedores.add(ven);
            return ven;
        }return ven;
    }

    public VendedorWeb actualizar(VendedorWeb ven){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaVendedores.size(); i++) {
            if ((listaVendedores.get(i).getVendedor() == ven.getVendedor())) {
                id = ven.getIdVenderdor();
                idPosicion = 1;
            }
        }

        VendedorWeb vendedor1 = new VendedorWeb();
        vendedor1.setIdVenderdor(id);
        vendedor1.setVendedor(ven.getVendedor());;

        listaVendedores.set(idPosicion, vendedor1);
        return vendedor1;
    }

    public void eliminar(int id){
        if(listaVendedores.size()==1){
            VendedorWeb vendedor = buscarPorId(id);
            if (vendedor != null) {
                listaVendedores.remove(vendedor);
            }
        }
    }
}
