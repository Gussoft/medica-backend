package com.gussoft.medicabackend.service.impl;

import com.gussoft.medicabackend.models.Especialidad;
import com.gussoft.medicabackend.repository.EspecialidadRepository;
import com.gussoft.medicabackend.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository repo;

    @Override
    public Especialidad registrar(Especialidad esp) {
        return repo.save(esp);
    }

    @Override
    public Especialidad modificar(Especialidad esp) {
        return repo.save(esp);
    }

    @Override
    public List<Especialidad> listar() {
        return repo.findAll();
    }

    @Override
    public Especialidad leerById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
