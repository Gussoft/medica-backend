package com.gussoft.medicabackend.repository;

import com.gussoft.medicabackend.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ConsultaExamenRepository extends JpaRepository<Consulta, Integer> {

    //@Transactional // se envio al service
    @Modifying
    @Query(value = "INSERT INTO consulta_examen(id_consulta, id_examen) VALUES (:idconsulta, :idexamen)", nativeQuery = true)
    Integer registrarQuery(@Param("idconsulta")Integer idconsulta, @Param("idexamen")Integer idexamen);
}
