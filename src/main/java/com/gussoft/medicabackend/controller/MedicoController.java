package com.gussoft.medicabackend.controller;

import com.gussoft.medicabackend.exception.ModelNotFoundException;
import com.gussoft.medicabackend.models.Medico;

import com.gussoft.medicabackend.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @GetMapping("/")
    public ResponseEntity<List<Medico>> listar(){
        List<Medico>lista = service.listar();
        return new ResponseEntity<List<Medico>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> leer(@PathVariable("id") Integer id){
        Medico medico = service.leerById(id);
       if (medico == null){
           throw new ModelNotFoundException("Id no encontrado : " + id);
       }
        return new ResponseEntity<>(medico,HttpStatus.OK);
    }
    //Modo super Sayan 3 de richarson
    /*@GetMapping("/hateoas/{id}")
    public Resource<Medico> leerxHateoas(@PathVariable("id") Integer id){
        Medico medico = service.leerById(id);
        if (medico == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }
        Resource<Medico> resource = new Resource<Medico>(medico);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).leer(id));
        resource.add(linkTo.withRel("paciente-resource"));
        return resource;
    }*/

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody Medico obj){
        Medico medico = service.registrar(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Medico obj){
        Medico medico = service.modificar(obj);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleted(@PathVariable("id") Integer id){
        Medico medico =  service.leerById(id);
        if (medico == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(medico,HttpStatus.OK);
    }
}
