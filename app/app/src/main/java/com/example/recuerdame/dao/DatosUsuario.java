package com.example.recuerdame.dao;

import android.content.Context;
import com.example.recuerdame.modelos.Usuario;
import com.example.recuerdame.utilidades.Preferencias;

import java.util.Date;

public class DatosUsuario {
    private Preferencias preferencias;
    private final Context context;

    public DatosUsuario(Context context) {
        this.context = context;
        this.preferencias = new Preferencias(context);
    }

    public void guardarUsuario(Usuario usuario) {
        preferencias.guardarUsuariosDesdeJava(usuario.getNombre(), usuario.getFechaNacimiento());
    }

    public Usuario leerUsuario() {
        String nombre = preferencias.obtenerNombreUsuarioDesdeJava();
        Date fechaNacimiento = preferencias.obtenerFechaNacimientoDesdeJava();
        return new Usuario(nombre, fechaNacimiento);
    }

    public void guardarNombreUsuario(String nombre) {
        preferencias.guardarNombreUsuarioDesdeJava(nombre);
    }

    public void guardarFechaNacimiento(Date fechaNacimiento) {
        preferencias.guardarFechaNacimientoDesdeJava(fechaNacimiento);
    }

    public Boolean obtenerModoOscuro() {
        return preferencias.obtenerModoOscuroDesdeJava();
    }

    public void guardarModoOscuro(Boolean modoOscuro) {
        preferencias.guardarModoOscuroDesdeJava(modoOscuro);
    }

    public Boolean obtenerAltoContraste() {
        return preferencias.obtenerAltoContrasteDesdeJava();
    }

    public void guardarAltoContraste(Boolean altoContraste) {
        preferencias.guardarAltoContrasteDesdeJava(altoContraste);
    }

    public int obtenerTamanoFuente() {
        return preferencias.obtenerTamanoFuenteDesdeJava();
    }

    public void guardarTamanoFuente(int tamanoFuente) {
        preferencias.guardarTamanoFuenteDesdeJava(tamanoFuente);
    }

    public void guardarPrimeraVez(Boolean primeraVez) {
        preferencias.guardarPrimeraVezDesdeJava(primeraVez);
    }

    public Boolean obtenerPrimeraVez() {
        return preferencias.obtenerPrimeraVezDesdeJava();
    }
}
