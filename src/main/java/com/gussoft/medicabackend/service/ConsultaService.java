package com.gussoft.medicabackend.service;

import com.gussoft.medicabackend.models.Consulta;
import com.gussoft.medicabackend.models.dto.ConsultaListExamen;
import com.gussoft.medicabackend.models.dto.ConsultaResumen;

import java.util.List;

public interface ConsultaService extends CRUD<Consulta>{

    Consulta resgistrarTrans(ConsultaListExamen consultaDTO);

    //List<Consulta> buscar(FiltroConsultaDTO filtro);

    List<ConsultaResumen> listarResumen();

    byte[] generarReporte();
}
