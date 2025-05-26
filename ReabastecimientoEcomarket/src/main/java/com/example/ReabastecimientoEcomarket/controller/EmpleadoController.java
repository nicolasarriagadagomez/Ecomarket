package com.example.ReabastecimientoEcomarket.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ReabastecimientoEcomarket.model.Empleado;
import com.example.ReabastecimientoEcomarket.service.EmpleadoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleado() {
        List<Empleado> empleados = empleadoService.getEmpleados();
        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleados);
    }

    @PostMapping
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado emp) {
        Empleado empleado = empleadoService.saveEmpleado(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleado);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empleado> buscaEmpleado(@PathVariable int id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable int id, @RequestBody Empleado emp) {
        try{
            Empleado empleado = empleadoService.getEmpleadoById(id);
            empleado.setNombre(emp.getNombre());
            empleado.setCargo(emp.getCargo());
            empleado.setTelefono(emp.getTelefono());
            empleado.setEmail(emp.getEmail());

            empleadoService.saveEmpleado(empleado);
            return ResponseEntity.ok(empleado);
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable int id) {
        try{
            empleadoService.deleteEmpleado(id);
            return ResponseEntity.noContent().build();
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
    }
}
