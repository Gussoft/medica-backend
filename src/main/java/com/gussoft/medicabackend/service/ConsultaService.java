package com.gussoft.medicabackend.service;

import com.gussoft.medicabackend.models.Consulta;
import com.gussoft.medicabackend.models.dto.ConsultaListExamen;

public interface ConsultaService extends CRUD<Consulta>{

    Consulta resgistrarTrans(ConsultaListExamen consultaDTO);
}
