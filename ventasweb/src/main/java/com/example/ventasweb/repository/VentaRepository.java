package com.example.ventasweb.repository;

import com.example.ventasweb.model.Venta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VentaRepository {
    private List<Venta> listaVentas = new ArrayList<>();

    public List<Venta> obtenerVentas(){
        return listaVentas;
    }

    public Venta buscarPorId(int id){
        for (Venta venta : listaVentas) {
            if(venta.getIdVenta()==id){
                return venta;
            }
        }
        return null;
    }

    public Venta buscarPorComprador(String comprador){
        for (Venta venta : listaVentas) {
            if(venta.getComprador().equals(comprador)){
                return venta;
            }
        }return null;
    }

    public Venta buscarPorVendedor(String vendedor){
        for (Venta venta : listaVentas) {
            if(venta.getVendedor().equals(vendedor)){
                return venta;
            }
        }return null;
    }

    public Venta guardar(Venta ven){
        listaVentas.add(ven);
        return ven;
    }

    public Venta actualizar(Venta ven){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaVentas.size(); i++) {
            if ((listaVentas.get(i).getIdVenta() == ven.getIdVenta())) {
                id = ven.getIdVenta();
                idPosicion = 1;
            }
        }

        Venta venta1 = new Venta();
        venta1.setIdVenta(id);
        venta1.setComprador(ven.getComprador());
        venta1.setIdVendedor(ven.getIdVendedor());
        venta1.setTotal(idPosicion);
        venta1.setFechaVenta(ven.getFechaVenta());

        listaVentas.set(idPosicion, venta1);
        return venta1;
    }

    public void eliminar(int id){
        Venta venta = buscarPorId(id);
        if (venta != null) {
            listaVentas.remove(venta);
        }
    }


}
