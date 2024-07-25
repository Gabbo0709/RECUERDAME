package com.example.recuerdame.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.recuerdame.utilidades.Tiempo;
import com.example.recuerdame.enumerables.UnidadesDeTiempo;

public class Recordatorio extends ObjetoBase {
    private Date fecha;
    private Date hora;
    private int tipo; // 1. Un solo uso. 2. Parte de una rutina.
    private int prioridad;
    private Integer intervaloReestablecimiento;
    private String unidadTiempo;
    private boolean estado;

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
        this.estado = true;
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
        this.estado = true;
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
        this.estado = true;
    }
    //#endregion

    //#region Getters y Setters
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
    public boolean getEstado() {
        return this.estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    //#endregion

    //#region Métodos
    public void reestablecer() {
        UnidadesDeTiempo unidad = Enum.valueOf(UnidadesDeTiempo.class, this.unidadTiempo);
        switch (unidad) {
            case MINUTOS:
                this.fecha = Tiempo.addMinutos(this.fecha, this.intervaloReestablecimiento);
                this.hora = Tiempo.addMinutos(this.hora, this.intervaloReestablecimiento);
                break;
            case HORAS:
                this.fecha = Tiempo.addHoras(this.fecha, this.intervaloReestablecimiento);
                this.hora = Tiempo.addHoras(this.hora, this.intervaloReestablecimiento);
                break;
            case DIAS:
                this.fecha = Tiempo.addDias(this.fecha, this.intervaloReestablecimiento);
                break;
            case SEMANAS:
                this.fecha = Tiempo.addSemanas(this.fecha, this.intervaloReestablecimiento);
                break;
            case MESES:
                this.fecha = Tiempo.addMeses(this.fecha, this.intervaloReestablecimiento);
                break;
            case ANIOS:
                this.fecha = Tiempo.addAnios(this.fecha, this.intervaloReestablecimiento);
                break;
        }
        // Dar formato a this.fecha como "dd/MM/yyyy" y a this.hora como "HH:mm"
        String fechaFormateada = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(this.fecha);
        String horaFormateada = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(this.hora);
        try {
            this.fecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(fechaFormateada);
            this.hora = new SimpleDateFormat("HH:mm", Locale.getDefault()).parse(horaFormateada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //#endregion
}
