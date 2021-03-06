package com.gussoft.medicabackend.service.impl;

import com.gussoft.medicabackend.models.Paciente;
import com.gussoft.medicabackend.repository.PacienteRepository;
import com.gussoft.medicabackend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository repo;

    @Override
    public Paciente registrar(Paciente paciente) {
        return repo.save(paciente);
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        return repo.save(paciente);
    }

    @Override
    public List<Paciente> listar() {
        return repo.findAll();
    }

    @Override
    public Paciente leerById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
