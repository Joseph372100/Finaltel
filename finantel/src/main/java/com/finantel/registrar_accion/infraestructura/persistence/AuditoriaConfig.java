package com.finantel.registrar_accion.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class AuditoriaConfig {

    public String[] getAccionesPermitidas() {
        return new String[]{
            "Creación",
            "Edición",
            "Anulación",
            "Login exitoso",
            "Login fallido"
        };
    }
}