package com.gussoft.medicabackend.controller;

import com.gussoft.medicabackend.models.Paciente;
import com.gussoft.medicabackend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/")
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente>lista = pacienteService.listar();
        return new ResponseEntity<List<Paciente>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> readbyId(@PathVariable("id") Integer id){
       Paciente paciente = pacienteService.getById(id);
        return new ResponseEntity<>(paciente,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Paciente p){
        pacienteService.register(p);
        return new ResponseEntity<Object>(HttpStatus.CREATED);
    }

    @PutMapping
    public void modificar(@RequestBody Paciente p){
        pacienteService.modify(p);
    }

    @DeleteMapping("/{id}")
    public void deleted(@PathVariable("id") Integer id){
        pacienteService.deleted(id);
    }
}
