package com.example.recuerdame.modelos;

import java.util.Date;

public class Recordatorio {
    private String id;
    private String nombre;
    private Date fecha;
    private Date hora;
    private String descripcion;
    private int tipo; // 1. Un solo uso. 2. Parte de una rutina.
    private int prioridad;
    private Integer intervaloReestablecimiento;
    private String unidadTiempo;

    //#region Constructores
    public Recordatorio(String id, String nombre, Date fecha, Date hora, String descripcion, int tipo, int prioridad, Integer intervaloReestablecimiento, String unidadTiempo) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.intervaloReestablecimiento = intervaloReestablecimiento;
        this.unidadTiempo = unidadTiempo;
    }

    public Recordatorio (String nombre, Date fecha, Date hora, String descripcion, int tipo, int prioridad, Integer intervaloReestablecimiento, String unidadTiempo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.intervaloReestablecimiento = intervaloReestablecimiento;
        this.unidadTiempo = unidadTiempo;
    }

    public Recordatorio(String nombre, Date fecha, Date hora, String descripcion, int tipo, int prioridad) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.intervaloReestablecimiento = null;
        this.unidadTiempo = null;
    }
    //#endregion

    //#region Getters y Setters
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Date getFecha() {
        return this.fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getHora() {
        return this.hora;
    }
    public void setHora(Date hora) {
        this.hora = hora;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getTipo() {
        return this.tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public int getPrioridad() {
        return this.prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public Integer getIntervaloReestablecimiento() {
        return this.intervaloReestablecimiento;
    }
    public void setIntervaloReestablecimiento(Integer intervaloReestablecimiento) {
        this.intervaloReestablecimiento = intervaloReestablecimiento;
    }
    public String getUnidadTiempo() {
        return this.unidadTiempo;
    }
    public void setUnidadTiempo(String unidadTiempo) {
        this.unidadTiempo = unidadTiempo;
    }
    //#endregion
}
