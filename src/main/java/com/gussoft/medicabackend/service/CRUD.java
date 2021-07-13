package com.gussoft.medicabackend.service;

import java.util.List;

public interface CRUD<T> {

    T registrar(T t);
    T modificar(T t);
    T leerById(Integer id);
    List<T> listar();
    void eliminar(Integer id);

}
