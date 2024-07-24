package com.example.recuerdame.modelos;

import java.util.List;
import java.util.Random;
import java.util.Date;

public class Rutina extends ObjetoBase {
    private String categoria;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean estado;
    private List<Recordatorio> recordatorios;

    //#region Constructores
    public Rutina(String id, String nombre, String categoria, Date fechaInicio, Date fechaFin, boolean estado, String descripcion, List<Recordatorio> recordatorios) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.descripcion = descripcion;
        this.recordatorios = recordatorios;
    }
    //#endregion
    //#region Getters y Setters
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCategoria() {
        return this.categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public boolean getEstado() {
        return this.estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Recordatorio> getRecordatorios() {
        return this.recordatorios;
    }
    public void setRecordatorios(List<Recordatorio> recordatorios) {
        this.recordatorios = recordatorios;
    }
    //#endregion

    //#region Métodos

    public String generarId() {
        Random random = new Random();
        return "r" +
                this.categoria.substring(0, 3).toUpperCase() +
                this.nombre.substring(0, 3).toUpperCase() +
                random.nextInt(100);
    }
    
    public String generarIdRecordatorio(Recordatorio recordatorio) {
        return this.id +
                "-" +
                recordatorio.getNombre().substring(0, 3).toUpperCase() +
                recordatorio.getPrioridad();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorio.setId(this.generarIdRecordatorio(recordatorio));
        this.recordatorios.add(recordatorio);
    }

    public void eliminarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.remove(recordatorio);
    }

    public void modificarRecordatorio(Recordatorio recordatorio) {
        for (Recordatorio r : this.recordatorios) {
            if(r.getId().equals(recordatorio.getId())) {
                this.recordatorios.remove(r);
                this.recordatorios.add(recordatorio);
            }
        }
    }

    // #endregion
}
