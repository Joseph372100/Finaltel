package com.finantel.registrar_historial_cambios.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class HistorialCambiosConfig {

    public boolean hayCambios(String anterior, String nuevo) {
        return anterior != null && !anterior.equals(nuevo);
    }
}