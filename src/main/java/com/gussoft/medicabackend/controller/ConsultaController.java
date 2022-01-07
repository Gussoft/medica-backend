package com.gussoft.medicabackend.controller;

import com.gussoft.medicabackend.exception.ModelNotFoundException;
import com.gussoft.medicabackend.models.Consulta;
import com.gussoft.medicabackend.models.dto.ConsultaListExamen;
import com.gussoft.medicabackend.models.dto.ConsultaResumen;
import com.gussoft.medicabackend.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @GetMapping("/")
    public ResponseEntity<List<Consulta>> listar(){
        List<Consulta>lista = service.listar();
        return new ResponseEntity<List<Consulta>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> leer(@PathVariable("id") Integer id){
        Consulta name = service.leerById(id);
       if (name == null){
           throw new ModelNotFoundException("Id no encontrado : " + id);
       }
        return new ResponseEntity<>(name,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> registrar(@RequestBody ConsultaListExamen obj){
        Consulta name = service.resgistrarTrans(obj);//registrar change
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(name.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Object> modificar(@RequestBody Consulta obj){
        Consulta name = service.modificar(obj);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleted(@PathVariable("id") Integer id){
        Consulta name =  service.leerById(id);
        if (name == null){
            throw new ModelNotFoundException("Id no encontrado : " + id);
        }else{
            service.eliminar(id);
        }
        return new ResponseEntity<Object>(name,HttpStatus.OK);
    }

    @GetMapping(value = "/listarResumen")
    public ResponseEntity<List<ConsultaResumen>> listarResumen(){
        List<ConsultaResumen> consultas = new ArrayList<>();
        consultas = service.listarResumen();
        return new ResponseEntity<List<ConsultaResumen>>(consultas,HttpStatus.OK);
    }
}
