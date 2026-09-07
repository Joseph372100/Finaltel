package com.finantel.generar_libro_contable.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class LibroContableConfig {

    public boolean esPeriodoValido(String periodo) {
        return periodo != null && !periodo.isEmpty();
    }
}