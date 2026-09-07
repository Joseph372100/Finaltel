package com.finantel.conciliacion_bancaria.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class ConciliacionBancariaConfig {

    public boolean estaConciliado(Double diferencia) {
        return Math.abs(diferencia) < 0.01;
    }
}