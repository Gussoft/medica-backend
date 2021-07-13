package com.gussoft.medicabackend.service.impl;

import com.gussoft.medicabackend.models.Consulta;
import com.gussoft.medicabackend.repository.ConsultaRepository;
import com.gussoft.medicabackend.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaRepository repo;

    @Override
    public Consulta registrar(Consulta con) {
        con.getDetalleConsulta().forEach(det ->{
            det.setConsulta(con);
        });
        /*
        en la entidad detalleconsulta en el campo de consulta se agrego un @JsonIgnore
        para que al armar el Json omita ese atributo de momento
        y aqui lo iteremos...
        **/
        return repo.save(con);
    }

    @Override
    public Consulta modificar(Consulta con) {
        return repo.save(con);
    }

    @Override
    public List<Consulta> listar() {
        return repo.findAll();
    }

    @Override
    public Consulta leerById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}
