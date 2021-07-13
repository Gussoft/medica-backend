package com.gussoft.medicabackend.models.dto;

import com.gussoft.medicabackend.models.Consulta;
import com.gussoft.medicabackend.models.Examen;

import java.util.List;

public class ConsultaListExamen {

    private Consulta consulta;
    private List<Examen> examenList;

    public ConsultaListExamen() {
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }
}
