package com.example.recuerdame.repositorios;

import com.example.recuerdame.modelos.Rutina;
import com.example.recuerdame.modelos.Recordatorio;
import com.example.recuerdame.repositorios.RepositorioRecordatorio;
import com.example.recuerdame.dao.Datos;
import com.example.recuerdame.utilidades.Alarmas;
import java.util.List;
import android.content.Context;

public class RepositorioRutina {
    public static boolean crear(Rutina rutina, Context context) {
        Datos<Rutina> datos = new Datos<>(context, Rutina[].class);
        if(datos.crear(rutina)) {
            for(Recordatorio recordatorio : rutina.getRecordatorios()) {
                RepositorioRecordatorio.crear(recordatorio, context);
                Alarmas.INSTANCE.crearAlarma(context, recordatorio);
            }
        }
        return false;
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

    public static void desactivarRutina(Rutina rutina, Context context) {
        Datos<Rutina> datos = new Datos<>(context, Rutina[].class);
        rutina.modificarEstado(3, null, null);
        datos.modificar(rutina);
        for(Recordatorio recordatorio : rutina.getRecordatorios()) {
            Alarmas.INSTANCE.cancelarAlarma(context, recordatorio);
        }
    }
}
