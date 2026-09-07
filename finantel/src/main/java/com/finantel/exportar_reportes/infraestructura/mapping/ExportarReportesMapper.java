package com.finantel.exportar_reportes.infraestructura.mapping;

import com.finantel.exportar_reportes.dominio.entity.Reporte;
import org.springframework.stereotype.Component;

@Component
public class ExportarReportesMapper {

    public Reporte toReporte(String tipo, String formato, Integer total) {
        return new Reporte(tipo, formato, total);
    }
}