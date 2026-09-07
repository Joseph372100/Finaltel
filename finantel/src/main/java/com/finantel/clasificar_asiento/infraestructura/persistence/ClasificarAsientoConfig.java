package com.finantel.clasificar_asiento.infraestructura.persistence;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ClasificarAsientoConfig {

    public boolean esTipoValido(String tipo) {
        return List.of("Apertura", "Operación ordinaria", "Ajuste", "Cierre", "Reversión")
            .contains(tipo);
    }
}