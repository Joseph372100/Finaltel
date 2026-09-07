package com.finantel.generar_estados_financieros.infraestructura.mapping;

import com.finantel.generar_estados_financieros.dominio.entity.EstadoFinanciero;
import org.springframework.stereotype.Component;

@Component
public class EstadosFinancierosMapper {

    public EstadoFinanciero toEstado(String tipo, Double debe, Double haber) {
        return new EstadoFinanciero(tipo, debe, haber);
    }
}