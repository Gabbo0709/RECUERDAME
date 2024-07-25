package com.example.recuerdame.modelos;

import java.util.Date;
import com.example.recuerdame.utilidades.Preferencias;

public class Usuario {
    private String nombre;
    private Date fechaNacimiento;

    public Usuario(String nombre, Date fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
