package com.finantel.visualizar_reportes_graficos.infraestructura.mapping;

import com.finantel.visualizar_reportes_graficos.dominio.entity.ReporteGrafico;
import org.springframework.stereotype.Component;

@Component
public class ReportesGraficosMapper {

    public ReporteGrafico toGrafico(String tipo, Double valor, String etiqueta) {
        return new ReporteGrafico(tipo, valor, etiqueta);
    }
}