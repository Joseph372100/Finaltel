package com.finantel.exportar_reportes.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class ExportarReportesConfig {

    public boolean esFormatoValido(String formato) {
        return "PDF".equalsIgnoreCase(formato) || "Excel".equalsIgnoreCase(formato);
    }
}