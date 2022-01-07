package com.gussoft.medicabackend.repository;

import com.gussoft.medicabackend.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query(value = "select * from listarResumen()", nativeQuery = true)
    List<Object[]> listarResumen();
}
