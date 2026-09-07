package com.finantel.visualizar_reportes_graficos.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class ReportesGraficosConfig {

    public boolean hayDatos(int cantidad) {
        return cantidad > 0;
    }
}