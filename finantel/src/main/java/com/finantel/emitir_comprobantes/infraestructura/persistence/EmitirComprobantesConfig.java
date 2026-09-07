package com.finantel.emitir_comprobantes.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class EmitirComprobantesConfig {

    public boolean esMontoValido(Double monto) {
        return monto != null && monto > 0;
    }
}