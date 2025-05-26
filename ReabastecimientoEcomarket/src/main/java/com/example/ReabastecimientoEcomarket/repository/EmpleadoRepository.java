package com.example.ReabastecimientoEcomarket.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ReabastecimientoEcomarket.model.Empleado;

@Repository
public class EmpleadoRepository {

    private List<Empleado> listaEmpleados = new ArrayList<>();

    public List<Empleado> obtenerEmpleados(){
        return listaEmpleados;
    }

    public Empleado buscarPorId(int id){
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getId()==id) {
                return empleado;
            }
        }
        return null;
    }

    public Empleado guardar(Empleado emp){
        listaEmpleados.add(emp);
        return emp;
    }

    public Empleado actualizar(Empleado emp){
        int id=0;
        int posicion=0;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if(listaEmpleados.get(i).getId()==emp.getId()){
                id= emp.getId();
                posicion=i;
            }
        }
        
        Empleado empleado1 = new Empleado();
        empleado1.setId(id);
        empleado1.setNombre(emp.getNombre());
        empleado1.setCargo(emp.getCargo());
        empleado1.setTelefono(emp.getTelefono());
        empleado1.setEmail(emp.getEmail());

        listaEmpleados.set(posicion, empleado1);
        return empleado1;
    }

    public void eliminar(int id){
        Empleado emp = buscarPorId(id);
        if (emp!=null) {
            listaEmpleados.remove(emp);
        }
    }
}
