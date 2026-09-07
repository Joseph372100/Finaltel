package com.finantel.inactivar_asiento.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class InactivarAsientoConfig {

    public boolean puedeInactivar(String estado) {
        return "Activo".equalsIgnoreCase(estado);
    }

    public boolean estaBloqueado(String estado) {
        return "Cerrado".equalsIgnoreCase(estado);
    }
}