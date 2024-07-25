package com.example.recuerdame.utilidades

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class Preferencias (private val context: Context) {
    private val preferencias = "settings"
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = preferencias)

    // Definir las claves de las preferencias
    companion object {
        val NOMBRE_USUARIO = stringPreferencesKey("nombre_usuario")
        val FECHA_NACIMIENTO = stringPreferencesKey("fecha_nacimiento")
        val ALTO_CONTRASTE = stringPreferencesKey("alto_contraste")
        val MODO_OSCURO = stringPreferencesKey("modo_oscuro")
        val TAMANO_FUENTE = stringPreferencesKey("tamano_fuente")
        val PRIMERA_VEZ = stringPreferencesKey("primera_vez")
    }

    //#region Métodos para guardar y leer datos de usuario

    // Guardar datos de usuario en DataStore
    private suspend fun guardarUsuario(nombre: String, fechaNacimiento: Date) {
        try {
            // Se editan las preferencias del usuario de las claves NOMBRE_USUARIO y FECHA_NACIMIENTO
            context.dataStore.edit { preferences ->
                preferences[NOMBRE_USUARIO] = nombre
                preferences[FECHA_NACIMIENTO] =
                    SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(fechaNacimiento)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // Guardar datos de usuario en DataStore desde Java
    fun guardarUsuariosDesdeJava(nombre: String, fechaNacimiento: Date) {
        // Llamar a la función de corrutina
        CoroutineScope(Dispatchers.IO).launch {
            guardarUsuario(nombre, fechaNacimiento)
        }
    }

    // Leer nombre de usuario desde DataStore como un flujo de datos Flow<String>
    private fun obtenerNombreUsuario(): Flow<String> = context.dataStore.data
        .map { preferences ->
            preferences[NOMBRE_USUARIO] ?: ""
        }

    // Leer nombre de usuario desde Java como un String
    fun obtenerNombreUsuarioDesdeJava(): String {
        // Se usa runBlocking para esperar a que el flujo de datos se emita
        return runBlocking(Dispatchers.IO) {
            obtenerNombreUsuario().first()
        }
    }

    // Leer fecha de nacimiento desde DataStore como un flujo de datos Flow<Date>
    private fun obtenerFechaNacimiento(): Flow<Date> = context.dataStore.data
        .map { preferences ->
            val fechaNacimientoTexto = preferences[FECHA_NACIMIENTO]
            if (fechaNacimientoTexto != null) {
                return@map SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(
                    fechaNacimientoTexto
                )
            } else {
                return@map SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("01/01/1900")
            }
        }

    // Leer fecha de nacimiento desde Java como un Date
    fun obtenerFechaNacimientoDesdeJava(): Date {
        return runBlocking(Dispatchers.IO) {
            obtenerFechaNacimiento().first()
        }
    }

    // Guardar nombre de usuario en DataStore
    private suspend fun guardarNombreUsuario(nombre: String) {
        context.dataStore.edit { preferences ->
            preferences[NOMBRE_USUARIO] = nombre
        }
    }

    // Guardar nombre de usuario en DataStore desde Java
    fun guardarNombreUsuarioDesdeJava(nombre: String) {
        // Llamar a la función de corrutina
        CoroutineScope(Dispatchers.IO).launch {
            guardarNombreUsuario(nombre)
        }
    }

    // Guardar fecha de nacimiento en DataStore
    private suspend fun guardarFechaNacimiento(fechaNacimiento: Date) {
        // Formatear fechaNacimiento en texto de formato "dd/MM/yyyy"
        val fechaNacimientoTexto =
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(fechaNacimiento)
        context.dataStore.edit { preferences ->
            preferences[FECHA_NACIMIENTO] = fechaNacimientoTexto
        }
    }

    // Guardar fecha de nacimiento en DataStore desde Java
    fun guardarFechaNacimientoDesdeJava(fechaNacimiento: Date) {
        // Llamar a la función de corrutina
        CoroutineScope(Dispatchers.IO).launch {
            guardarFechaNacimiento(fechaNacimiento)
        }
    }
    //#endregion

    //#region Métodos para guardar y leer preferencias generales (modo oscuro, alto contraste, tamaño de fuente)

    // Guardar preferencia de modo oscuro
    private suspend fun guardarModoOscuro(modoOscuro: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[MODO_OSCURO] = modoOscuro.toString()
        }
    }

    // Guardar preferencia de modo oscuro desde Java
    fun guardarModoOscuroDesdeJava(modoOscuro: Boolean) {
        // Llamar a la función de corrutina
        CoroutineScope(Dispatchers.IO).launch {
            guardarModoOscuro(modoOscuro)
        }
    }

    // Leer preferencia de modo oscuro como un flujo de datos Flow<Boolean>
    private fun obtenerModoOscuro(): Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[MODO_OSCURO]?.toBoolean() ?: false
        }

    // Leer preferencia de modo oscuro desde Java como un Boolean
    fun obtenerModoOscuroDesdeJava(): Boolean {
        return runBlocking(Dispatchers.IO) {
            obtenerModoOscuro().first()
        }
    }

    // Guardar preferencia de modo de alto contraste
    private suspend fun guardarAltoContraste(altoContraste: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[ALTO_CONTRASTE] = altoContraste.toString()
        }
    }

    // Guardar preferencia de modo alto contraste desde Java
    fun guardarAltoContrasteDesdeJava(altoContraste: Boolean) {
        // Llamar a la función de corrutina
        CoroutineScope(Dispatchers.IO).launch {
            guardarAltoContraste(altoContraste)
        }
    }

    // Leer preferencia de modo de alto contraste como un flujo de datos Flow<Boolean>
    private fun obtenerAltoContraste(): Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[MODO_OSCURO]?.toBoolean() ?: false
        }

    // Leer preferencia de modo alto contraste desde Java como un Boolean
    fun obtenerAltoContrasteDesdeJava(): Boolean {
        return runBlocking(Dispatchers.IO) {
            obtenerAltoContraste().first()
        }
    }

    // Guardar tamaño de fuente
    private suspend fun guardarTamanoFuente(tamanoFuente: Int) {
        context.dataStore.edit { preferences ->
            preferences[TAMANO_FUENTE] = tamanoFuente.toString()
        }
    }

    // Guardar tamaño de fuente desde Java
    fun guardarTamanoFuenteDesdeJava(tamanoFuente: Int) {
        // Llamar a la función de corrutina
        CoroutineScope(Dispatchers.IO).launch {
            guardarTamanoFuente(tamanoFuente)
        }
    }

    // Leer tamaño de fuente como un flujo de datos Flow<Int>
    private fun obtenerTamanoFuente(): Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[TAMANO_FUENTE]?.toInt() ?: 14
        }

    // Leer tamaño de fuente desde Java como un Int
    fun obtenerTamanoFuenteDesdeJava(): Int {
        return runBlocking(Dispatchers.IO) {
            obtenerTamanoFuente().first()
        }
    }

    //#endregion

    //#region Métodos para guardar y leer la informacion de la primera vez que se abre la app
    // Guardar informacion de la primera vez que se abre la app
    private suspend fun guardarPrimeraVez(primeraVez: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PRIMERA_VEZ] = primeraVez.toString()
        }
    }

    // Guardar informacion de la primera vez
    fun guardarPrimeraVezDesdeJava(primeraVez: Boolean) {
        // Llamar a la función de corrutina
        CoroutineScope(Dispatchers.IO).launch {
            guardarPrimeraVez(primeraVez)
        }
    }

    // Leer informacion de la primera vez que se abre la app
    private fun obtenerPrimeraVez(): Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[PRIMERA_VEZ]?.toBoolean() ?: true
        }

    // Leer informacion de la primera vez desde Java
    fun obtenerPrimeraVezDesdeJava(): Boolean {
        return runBlocking(Dispatchers.IO) {
            obtenerPrimeraVez().first()
        }
    }
    //#endregion
}