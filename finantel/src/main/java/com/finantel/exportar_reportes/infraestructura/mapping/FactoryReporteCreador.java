package com.finantel.exportar_reportes.infraestructura.mapping;

public class FactoryReporteCreador {

    public static FactoryReporte crearReporte(String tipo) {
        switch (tipo.toUpperCase()) {
            case "PDF":   return new FactoryReportePDF();
            case "EXCEL": return new FactoryReporteExcel();
            default: throw new IllegalArgumentException("Tipo no soportado: " + tipo);
        }
    }
}