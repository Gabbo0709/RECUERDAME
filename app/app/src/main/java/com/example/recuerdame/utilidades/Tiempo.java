package com.example.recuerdame.utilidades;

import java.util.Date;
import java.util.Calendar;
import java.time.LocalTime;

public class Tiempo {
    public static Date obtenerFechaActual() {
        Calendar calendario = Calendar.getInstance();
        return calendario.getTime();
    }

    public static String obtenerHoraActual() {
        LocalTime hora = LocalTime.now();
        return hora.toString();
    }

    public static Date addDias(Date fecha, int dias) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.DAY_OF_MONTH, dias);
        return calendario.getTime();
    }

    public static Date addSemanas(Date fecha, int semanas) {
        return addDias(fecha, 7 * semanas);
    }

    public static Date addMeses(Date fecha, int meses) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.MONTH, meses);
        return calendario.getTime();
    }

    public static Date addAnios(Date fecha, int anios) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.YEAR, anios);
        return calendario.getTime();
    }

    public static Date addMinutos(Date fecha, int minutos) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.MINUTE, minutos);
        return calendario.getTime();
    }

    public static Date addHoras(Date fecha, int horas) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fecha);
        calendario.add(Calendar.HOUR, horas);
        return calendario.getTime();
    }

}
