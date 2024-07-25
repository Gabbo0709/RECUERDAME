package com.example.recuerdame.utilidades

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.getSystemService
import com.example.recuerdame.transmision.RecibidorAlarma
import com.example.recuerdame.modelos.Recordatorio
import java.util.*

object Alarmas {
    fun crearAlarma(context: Context, recordatorio: Recordatorio) {
        val alarmManager = getSystemService(context, RecibidorAlarma::class.java)
        if (alarmManager != null) {
            val intent = Intent(context, RecibidorAlarma::class.java).apply {
                putExtra("recordatorioID", recordatorio.id)
            }
        }
    }
}