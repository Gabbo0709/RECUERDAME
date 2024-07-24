package com.example.recuerdame.repositorios;

import com.example.recuerdame.modelos.Recordatorio;
import com.example.recuerdame.modelos.Rutina;
import com.example.recuerdame.dao.Datos;
import java.util.List;
import android.content.Context;

public class RepositorioRecordatorio {
    public static boolean crear(Recordatorio recordatorio, Context context) {
        Datos<Recordatorio> datos = new Datos<>(context, Recordatorio[].class);
        return datos.crear(recordatorio);
    }

    public static boolean modificar(Recordatorio recordatorio, Context context) {
        Datos<Recordatorio> datos = new Datos<>(context, Recordatorio[].class);
        return datos.modificar(recordatorio);
    }

    public static boolean eliminar(Recordatorio recordatorio, Context context) {
        Datos<Recordatorio> datos = new Datos<>(context, Recordatorio[].class);
        return datos.eliminar(recordatorio);
    }

    public static List<Recordatorio> obtenerTodos(Context context) {
        Datos<Recordatorio> datos = new Datos<>(context, Recordatorio[].class);
        return datos.obtenerTodos();
    }

    public static boolean agregarRutina(Recordatorio recordatorio, Rutina rutina, Context context) {
        Datos<Rutina> datosRutina = new Datos<>(context, Rutina[].class);
        Datos<Recordatorio> datosRecordatorio = new Datos<>(context, Recordatorio[].class);
        rutina.agregarRecordatorio(recordatorio);
        return datosRutina.modificar(rutina) && datosRecordatorio.modificar(recordatorio);
    }
}
