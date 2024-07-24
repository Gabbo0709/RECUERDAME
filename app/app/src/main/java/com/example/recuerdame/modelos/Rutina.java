package com.example.recuerdame.modelos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.Date;
import com.example.recuerdame.enumerables.UnidadesDeTiempo;
import com.example.recuerdame.utilidades.Tiempo;

public class Rutina extends ObjetoBase {
    private String categoria;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer estado; // 1. Activa. 2. Pausada. 3. Desactivada. (Se puede considerar desactivada al finalizarse).
    private List<Recordatorio> recordatorios;

    //#region Constructores
    public Rutina(String id, String nombre, String categoria, Date fechaInicio, Date fechaFin, Integer estado, String descripcion, List<Recordatorio> recordatorios) {
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
    public Integer getEstado() {
        return this.estado;
    }
    public void setEstado(Integer estado) {
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

    // Método para modificar el estado de la rutina. Si la rutina se desactiva, se puede especificar el tiempo por el que se desactivará, considerándose pausada.
    public void modificarEstado(Integer estado, Integer tiempoDesactivacion, String unidadTiempo) {
        this.estado = estado;
        if (estado == 3) {
            return;
        }
        if (tiempoDesactivacion == null || unidadTiempo == null) {
            return;
        }
        UnidadesDeTiempo unidad = Enum.valueOf(UnidadesDeTiempo.class, unidadTiempo);
        switch (unidad) {
            case DIAS:
                this.fechaInicio = Tiempo.addDias(this.fechaInicio, tiempoDesactivacion);
                this.fechaFin = Tiempo.addDias(this.fechaFin, tiempoDesactivacion);
                break;
            case SEMANAS:
                this.fechaInicio = Tiempo.addSemanas(this.fechaInicio, tiempoDesactivacion);
                this.fechaFin = Tiempo.addSemanas(this.fechaFin, tiempoDesactivacion);
                break;
            case MESES:
                this.fechaInicio = Tiempo.addMeses(this.fechaInicio, tiempoDesactivacion);
                this.fechaFin = Tiempo.addMeses(this.fechaFin, tiempoDesactivacion);
                break;
            case ANIOS:
                this.fechaInicio = Tiempo.addAnios(this.fechaInicio, tiempoDesactivacion);
                this.fechaFin = Tiempo.addAnios(this.fechaFin, tiempoDesactivacion);
                break;
            default:
                break;
        }
    }

    public void reestablecerRecordatorio(Recordatorio recordatorio) {
        for (Recordatorio r : this.recordatorios) {
            if(r.getId().equals(recordatorio.getId())) {
                r.reestablecer();
            }
        }
    }

    // #endregion
}
