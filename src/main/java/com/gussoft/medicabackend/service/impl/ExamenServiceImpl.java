package com.gussoft.medicabackend.service.impl;

import com.gussoft.medicabackend.models.Examen;
import com.gussoft.medicabackend.models.Paciente;
import com.gussoft.medicabackend.repository.ExamenRepository;
import com.gussoft.medicabackend.service.ExamenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository repo;

    @Override
    public Examen registrar(Examen examen) {
        return repo.save(examen);
    }

    @Override
    public Examen modificar(Examen examen) {
        return repo.save(examen);
    }

    @Override
    public List<Examen> listar() {
        return repo.findAll();
    }

    @Override
    public Examen leerById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
