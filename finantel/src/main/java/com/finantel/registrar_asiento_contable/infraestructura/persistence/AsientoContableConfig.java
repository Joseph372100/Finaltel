package com.finantel.registrar_asiento_contable.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class AsientoContableConfig {

    public boolean esPeriodoCerrado(String estado) {
        return "Cerrado".equalsIgnoreCase(estado);
    }

    public boolean esAnulado(String estado) {
        return "Anulado".equalsIgnoreCase(estado);
    }
}