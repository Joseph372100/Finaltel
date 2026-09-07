package com.finantel.buscar_asiento.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class BuscarAsientoConfig {

    public boolean esFiltroValido(String filtro) {
        return filtro != null && !filtro.isEmpty();
    }
}