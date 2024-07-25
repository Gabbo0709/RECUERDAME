package com.example.recuerdame.utilidades

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import com.example.recuerdame.transmision.RecibidorAlarma
import com.example.recuerdame.modelos.Recordatorio
import java.time.Instant
import java.time.ZoneId
import java.util.*
import kotlin.math.absoluteValue

object Alarmas {
    @SuppressLint("ScheduleExactAlarm")
    fun crearAlarma(context: Context, recordatorio: Recordatorio) {
        val manejadorAlarmas = getSystemService(context, AlarmManager::class.java) as AlarmManager
            val intent = Intent(context, RecibidorAlarma::class.java).apply {
                putExtra("recordatorio", recordatorio.id)
            }

            val requestCode = recordatorio.id.hashCode().absoluteValue

            val pendingIntent = PendingIntent.getBroadcast(
                context,
                requestCode,
                intent,
                PendingIntent.FLAG_IMMUTABLE
            )

            manejadorAlarmas.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calcularTiempoParaSonarEnMilisegundos(recordatorio),
                pendingIntent
            )
    }

    fun cancelarAlarma(context: Context, recordatorio: Recordatorio) {
        val manejadorAlarmas = getSystemService(context, AlarmManager::class.java) as AlarmManager
        val intent = Intent(context, RecibidorAlarma::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            recordatorio.id.hashCode().absoluteValue,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        manejadorAlarmas.cancel(pendingIntent)
    }

    private fun calcularTiempoParaSonarEnMilisegundos(recordatorio: Recordatorio): Long {
        val fechaRecordatorio = recordatorio.fecha
        val instante: Instant = recordatorio.hora.toInstant()
        val hora = instante.atZone(ZoneId.systemDefault()).toLocalDateTime()
        val fechaYHoraRecordatorio = Calendar.getInstance().apply {
            time = fechaRecordatorio
            set(Calendar.HOUR_OF_DAY, hora.hour)
            set(Calendar.MINUTE, hora.minute)
            set(Calendar.SECOND, 0)
        }
        val fechaActual = Calendar.getInstance()
        val diferencia = fechaYHoraRecordatorio.timeInMillis - fechaActual.timeInMillis
        return diferencia
    }
}