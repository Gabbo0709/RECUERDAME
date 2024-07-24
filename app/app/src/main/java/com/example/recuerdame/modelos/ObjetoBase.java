package com.example.recuerdame.modelos;

public class ObjetoBase {
    protected String id;
    protected String nombre;
    protected String descripcion;

    //#region Getters y Setters
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    //#endregion
}
