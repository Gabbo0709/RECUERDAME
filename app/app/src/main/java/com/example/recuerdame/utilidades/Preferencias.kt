package com.example.recuerdame.utilidades

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import java.util.Date

class Preferencias (context: Context) {
    private val PREFERENCIAS_USUARIO = "settings"
    private val currentContext = context
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCIAS_USUARIO)

    suspend fun guardarUsuario(nombre: String, fechaNacimiento: Date) {
        val NOMBRE_USUARIO = stringPreferencesKey("nombreUsuario")
        val FECHA_NACIMIENTO = stringPreferencesKey("fechaNacimiento")
        currentContext.dataStore.edit { preferences ->
            preferences[NOMBRE_USUARIO] = nombre
            preferences[FECHA_NACIMIENTO] = fechaNacimiento.toString()
        }
    }
}