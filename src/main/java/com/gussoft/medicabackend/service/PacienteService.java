package com.gussoft.medicabackend.service;

import com.gussoft.medicabackend.models.Paciente;

import java.util.List;

public interface PacienteService {

    void register(Paciente paciente);
    void modify(Paciente paciente);
    List<Paciente> listar();
    Paciente getById(Integer id);
    void deleted(Integer id);
}
