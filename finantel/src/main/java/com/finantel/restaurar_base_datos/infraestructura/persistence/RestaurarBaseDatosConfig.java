package com.finantel.restaurar_base_datos.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class RestaurarBaseDatosConfig {

    public boolean tienePermisos(String rol) {
        return "Administrador".equalsIgnoreCase(rol);
    }

    public boolean esPuntoValido(Integer id) {
        return id != null && id > 0;
    }
}