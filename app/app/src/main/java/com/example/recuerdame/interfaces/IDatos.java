package com.example.recuerdame.interfaces;

import java.util.List;

public interface IDatos <T> {
    boolean crear(T objeto);
    boolean modificar(T objeto);
    boolean eliminar(T objeto);
    List<T> obtenerTodos();
}
