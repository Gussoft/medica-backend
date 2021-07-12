package com.gussoft.medicabackend.models;

import javax.persistence.*;

@Entity
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 80)
    private String nombres;

    @Column(nullable = false, length = 80)
    private String apellidos;

    @Column(nullable = false, length = 12)
    private String CMP;

    public Medico() {
    }

    public Medico(Integer id, String nombres, String apellidos, String CMP) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.CMP = CMP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCMP() {
        return CMP;
    }

    public void setCMP(String CMP) {
        this.CMP = CMP;
    }
}
