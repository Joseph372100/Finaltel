package com.finantel.duplicar_asiento.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class DuplicarAsientoConfig {

    public boolean puededuplicar(String estado) {
        return "Activo".equalsIgnoreCase(estado);
    }
}