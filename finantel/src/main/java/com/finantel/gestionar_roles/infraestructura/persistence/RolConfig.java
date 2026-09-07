package com.finantel.gestionar_roles.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class RolConfig {

    public String[] getRolesDisponibles() {
        return new String[]{
            "Administrador",
            "Contador General",
            "Auditor",
            "Personal Autorizado"
        };
    }
}