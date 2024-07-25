package com.example.recuerdame.transmision;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.example.recuerdame.modelos.Recordatorio;

public class RecibidorAlarma extends BroadcastReceiver {

    private Recordatorio recordatorio;

    public RecibidorAlarma(Recordatorio recordatorio) {
        this.recordatorio = recordatorio;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Acciones a realizar cuando se activa la alarma
    }
}
