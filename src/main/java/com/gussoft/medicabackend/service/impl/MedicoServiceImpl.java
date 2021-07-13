package com.gussoft.medicabackend.service.impl;

import com.gussoft.medicabackend.models.Medico;
import com.gussoft.medicabackend.repository.MedicoRepository;
import com.gussoft.medicabackend.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository repo;

    @Override
    public Medico registrar(Medico medico) {
        return repo.save(medico);
    }

    @Override
    public Medico modificar(Medico medico) {
        return repo.save(medico);
    }

    @Override
    public List<Medico> listar() {
        return repo.findAll();
    }

    @Override
    public Medico leerById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
