package com.finantel.validar_cuentas.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class ValidarCuentasConfig {

    public boolean esCuentaActiva(String estado) {
        return "Activo".equalsIgnoreCase(estado);
    }
}