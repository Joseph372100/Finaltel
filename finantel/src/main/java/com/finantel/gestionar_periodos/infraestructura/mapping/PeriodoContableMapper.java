package com.finantel.gestionar_periodos.infraestructura.mapping;

import com.finantel.gestionar_periodos.dominio.entity.PeriodoContable;
import org.springframework.stereotype.Component;

@Component
public class PeriodoContableMapper {

    public PeriodoContable toEntity(String periodo, String fechaInicio, String fechaCierre) {
        PeriodoContable p = new PeriodoContable();
        p.setPeriodo(periodo);
        p.setFechaInicio(java.time.LocalDate.parse(fechaInicio));
        p.setFechaCierre(java.time.LocalDate.parse(fechaCierre));
        p.setEstado("Activo");
        return p;
    }
}