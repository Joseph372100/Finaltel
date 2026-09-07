package com.finantel.buscar_asiento.infraestructura.mapping;

import org.springframework.stereotype.Component;

@Component
public class BuscarAsientoMapper {

    public String normalizarFiltro(String filtro) {
        return filtro != null ? filtro.trim().toLowerCase() : "";
    }
}