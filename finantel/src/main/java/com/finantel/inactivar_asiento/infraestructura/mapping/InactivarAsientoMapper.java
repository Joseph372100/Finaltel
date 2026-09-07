package com.finantel.inactivar_asiento.infraestructura.mapping;

import org.springframework.stereotype.Component;

@Component
public class InactivarAsientoMapper {

    public String toEstado(boolean inactivo) {
        return inactivo ? "Inactivo" : "Activo";
    }
}