package com.finantel.realizar_copia_seguridad.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class CopiaSeguridadConfig {

    public boolean tienePermisos(String rol) {
        return "Administrador".equalsIgnoreCase(rol);
    }
}