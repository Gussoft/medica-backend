package com.gussoft.medicabackend.controller;

import com.gussoft.medicabackend.exception.ModelNotFoundException;
import com.gussoft.medicabackend.models.Especialidad;
import com.gussoft.medicabackend.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService service;

    @GetMapping("/")
    public ResponseEntity<List<Especialidad>> listar(){
        List<Especialidad>lista = service.listar();
        return new ResponseEntity<List<Especialidad>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> leer(@PathVariable("id") Integer id){
        Especialidad esp = service.leerById(id);
       if (esp == null){
           throw new ModelNotFoundException("Id no encontrado : " + id);
       }
        return new ResponseEntity<>(esp,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Especialidad obj){
        Especialidad esp = service.registrar(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(esp.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Especialidad obj){
        Especialidad esp = service.modificar(obj);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleted(@PathVariable("id") Integer id){
        Especialidad esp =  service.leerById(id);
        if (esp == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(esp,HttpStatus.OK);
    }
}
