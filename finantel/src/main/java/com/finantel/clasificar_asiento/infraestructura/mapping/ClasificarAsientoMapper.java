package com.finantel.clasificar_asiento.infraestructura.mapping;

import org.springframework.stereotype.Component;

@Component
public class ClasificarAsientoMapper {

    public String toTipo(String tipo) {
        return tipo != null ? tipo.trim().toUpperCase() : "SIN_TIPO";
    }
}