package com.finantel.detectar_inconsistencias.infraestructura.mapping;

import com.finantel.detectar_inconsistencias.dominio.entity.Inconsistencia;
import org.springframework.stereotype.Component;

@Component
public class InconsistenciaMapper {

    public Inconsistencia toInconsistencia(Integer id, String error) {
        return new Inconsistencia(id, "Error contable", error);
    }
}