package com.finantel.detectar_inconsistencias.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class InconsistenciaConfig {

    public boolean estaBalanceado(Double debe, Double haber) {
        return Math.abs(debe - haber) <= 0.01;
    }
}