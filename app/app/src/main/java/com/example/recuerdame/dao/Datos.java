package com.example.recuerdame.dao;

import com.example.recuerdame.interfaces.IDatos;
import com.example.recuerdame.modelos.Rutina;
import com.example.recuerdame.modelos.ObjetoBase;
import com.example.recuerdame.utilidades.Archivos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Objects;

import android.content.Context;


public class Datos <T extends ObjetoBase> implements IDatos<T> {
    private final String contenidoArchivoActual;
    private final Gson gson;
    private final Class<T[]> tipoArray;
    private final Archivos archivos;

    public Datos(Context context, Class<T[]> tipoArray) {
        int tipo = Objects.equals(tipoArray, Rutina[].class) ? 1 : 2;
        this.archivos = new Archivos(context, tipo);
        this.contenidoArchivoActual = archivos.leerArchivo();
        this.tipoArray = tipoArray;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        DateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new com.google.gson.JsonDeserializer<Date>() {
           public Date deserialize(com.google.gson.JsonElement json, Type typeOff, com.google.gson.JsonDeserializationContext cntxt) {
               try {
                   String jsonValue = json.getAsString();
                   if(jsonValue.matches("\\d{4}-\\d{2}-\\d{2}"))
                       return dateFormat.parse(jsonValue);
                   else if (jsonValue.matches("\\d{2}:\\d{2}"))
                       return timeFormat.parse(jsonValue);
                    else
                        throw new java.text.ParseException("Fecha u hora no valida", 0);
               } catch (java.text.ParseException e) {
                   return null;
               }
           }
        });
        this.gson = builder.create();
    }

    @Override
    public boolean crear(T objeto) {
        List<T> objetos = this.obtenerTodos();
        objetos.add(objeto);
        return true;
    }

    @Override
    public boolean modificar(T objeto) {
        List<T> objetos = this.obtenerTodos();
        for(T o : objetos) {
            if(o.getId().equals(objeto.getId())) {
                o = objeto;
                break;
            }
        }
        return guardarObjetos(objetos);
    }

    @Override
    public boolean eliminar(T objeto) {
        List<T> objetos = this.obtenerTodos();
        objetos.remove(objeto);
        return guardarObjetos(objetos);
    }

    @Override
    public List<T> obtenerTodos() {
        List<T> objetos = new ArrayList<>();
        T[] objetosArray = gson.fromJson(contenidoArchivoActual, tipoArray);
        if(objetosArray != null) {
            objetos = new ArrayList<>(List.of(objetosArray));
        }
        return objetos;
    }

    private boolean guardarObjetos(List<T> objetos) {
        String contenido = gson.toJson(objetos);
        try {
            archivos.escribirArchivo(contenido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
