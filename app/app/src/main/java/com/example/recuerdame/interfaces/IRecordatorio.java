package com.example.recuerdame.interfaces;

import com.example.recuerdame.modelos.Recordatorio;

public interface IRecordatorio {
    public boolean crear(Recordatorio recordatorio);
    public boolean modificar(Recordatorio recordatorio);
    public boolean eliminar(Recordatorio recordatorio);
    public boolean agregarRutina(String idRutina);
}
