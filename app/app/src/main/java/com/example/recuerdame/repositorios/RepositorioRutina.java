package com.example.recuerdame.repositorios;

import com.example.recuerdame.modelos.Rutina;
import com.example.recuerdame.dao.Datos;
import java.util.List;
import android.content.Context;

public class RepositorioRutina {
    public static boolean crear(Rutina rutina, Context context) {
        Datos<Rutina> datos = new Datos<>(context, Rutina[].class);
        return datos.crear(rutina);
    }

    public static boolean modificar(Rutina rutina, Context context) {
        Datos<Rutina> datos = new Datos<>(context, Rutina[].class);
        return datos.modificar(rutina);
    }

    public static boolean eliminar(Rutina rutina, Context context) {
        Datos<Rutina> datos = new Datos<>(context, Rutina[].class);
        return datos.eliminar(rutina);
    }

    public static List<Rutina> obtenerTodos(Context context) {
        Datos<Rutina> datos = new Datos<>(context, Rutina[].class);
        return datos.obtenerTodos();
    }
}
