package com.gussoft.medicabackend.controller;

import com.gussoft.medicabackend.exception.ModelNotFoundException;
import com.gussoft.medicabackend.models.Examen;
import com.gussoft.medicabackend.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    @Autowired
    private ExamenService service;

    @GetMapping("/")
    public ResponseEntity<List<Examen>> listar(){
        List<Examen>lista = service.listar();
        return new ResponseEntity<List<Examen>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> leer(@PathVariable("id") Integer id){
        Examen examen = service.leerById(id);
       if (examen == null){
           throw new ModelNotFoundException("Id no encontrado : " + id);
       }
        return new ResponseEntity<>(examen,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Examen obj){
        Examen examen = service.registrar(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(examen.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Examen obj){
        Examen examen = service.modificar(obj);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleted(@PathVariable("id") Integer id){
        Examen examen =  service.leerById(id);
        if (examen == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(examen,HttpStatus.OK);
    }
}
