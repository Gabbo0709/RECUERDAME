package com.example.recuerdame.interfaces;

import com.example.recuerdame.modelos.Recordatorio;
import com.example.recuerdame.modelos.Rutina;

public interface IRutina {
    public boolean crear();
    public boolean modificar();
    public boolean eliminar();
    public boolean agregarRecordatorio(IRecordatorio recordatorio);
    public boolean eliminarRecordatorio(IRecordatorio recordatorio);
}
