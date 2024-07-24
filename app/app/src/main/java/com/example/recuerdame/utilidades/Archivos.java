package com.example.recuerdame.utilidades;

import android.content.Context;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivos {
    final String archivoDatos;
    final Context context;

    public Archivos(Context context, int tipoArchivo) {
        this.context = context;
        archivoDatos = (tipoArchivo == 1) ? "rutinas.json" : "recordatorios.json";
    }

    public void crearArchivo() {
        File archivo = new File(context.getFilesDir(), archivoDatos);
        if (archivo.exists())
            return;
        try {
            archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leerArchivo() {
        File archivo = new File(context.getFilesDir(), archivoDatos);
        if (!archivo.exists())
            return null;
        String resultado = null;
        try {
            StringBuilder contenido = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = reader.readLine()) != null) {
                contenido.append(line);
            }
            reader.close();
            resultado = contenido.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public void escribirArchivo(String contenido) {
        File archivo = new File(context.getFilesDir(), archivoDatos);
        if (!archivo.exists()) {
            this.crearArchivo();
            return;
        }
        try {
            FileWriter writer = new FileWriter(archivo);
            writer.write(contenido);
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
