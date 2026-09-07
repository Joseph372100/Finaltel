package com.finantel.duplicar_asiento.infraestructura.mapping;

import org.springframework.stereotype.Component;

@Component
public class DuplicarAsientoMapper {

    public String generarDescripcionCopia(String descripcionOriginal) {
        return "COPIA - " + descripcionOriginal;
    }
}