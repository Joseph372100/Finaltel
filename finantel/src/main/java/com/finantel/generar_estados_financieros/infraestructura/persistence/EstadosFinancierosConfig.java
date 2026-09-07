package com.finantel.generar_estados_financieros.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class EstadosFinancierosConfig {

    public boolean hayDatos(int cantidad) {
        return cantidad > 0;
    }
}