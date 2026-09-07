package com.finantel.exportar_reportes.infraestructura.mapping;

public class FactoryReportePDF implements FactoryReporte {

    @Override
    public String generar() {
        return "Reporte exportado en formato PDF — FINANTEL S.A.C.";
    }

    @Override
    public String getTipo() { return "PDF"; }

    @Override
    public String getPatron() { return "Patrón Factory Method — FactoryReportePDF"; }
}