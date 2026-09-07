package com.finantel.exportar_reportes.infraestructura.mapping;

public class FactoryReporteExcel implements FactoryReporte {

    @Override
    public String generar() {
        return "Reporte exportado en formato Excel — FINANTEL S.A.C.";
    }

    @Override
    public String getTipo() { return "EXCEL"; }

    @Override
    public String getPatron() { return "Patrón Factory Method — FactoryReporteExcel"; }
}