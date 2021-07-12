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
    public void register(Paciente paciente) {
        repo.save(paciente);
    }

    @Override
    public void modify(Paciente paciente) {
        repo.save(paciente);
    }

    @Override
    public List<Paciente> listar() {
        return repo.findAll();
    }

    @Override
    public Paciente getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleted(Integer id) {
        repo.deleteById(id);
    }
}
