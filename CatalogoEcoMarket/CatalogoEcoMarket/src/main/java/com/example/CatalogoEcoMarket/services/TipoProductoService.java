package com.example.CatalogoEcoMarket.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CatalogoEcoMarket.model.TipoProducto;
import com.example.CatalogoEcoMarket.repository.TipoProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoProductoService {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    public List<TipoProducto> obtenerTiposProducto() {
        return tipoProductoRepository.obtenerTipoProductos();
    }

    public TipoProducto obtenerTipoProductoPorId(int id) {
        return tipoProductoRepository.buscarPorId(id);
    }

    public TipoProducto guardarTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoRepository.guardar(tipoProducto);
    }

    public TipoProducto actualizarTipoProducto(TipoProducto tipoProducto) {
        return tipoProductoRepository.actualizar(tipoProducto);
    }

    public String eliminarTipoProducto(int id) {
        tipoProductoRepository.eliminar(id);
        return "Tipo de producto eliminado";
    }
}
