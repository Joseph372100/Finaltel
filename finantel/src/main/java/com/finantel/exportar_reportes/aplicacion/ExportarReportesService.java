package com.finantel.exportar_reportes.aplicacion;

import com.finantel.exportar_reportes.dominio.repository.ExportarReportesRepository;
import org.springframework.stereotype.Service;

@Service
public class ExportarReportesService {

    private final ExportarReportesRepository repo;

    public ExportarReportesService(ExportarReportesRepository repo) {
        this.repo = repo;
    }

    public String exportarPDF() {
        int total = repo.findAll().size();
        return "Reporte PDF generado con " + total + " asientos contables";
    }

    public String exportarExcel() {
        int total = repo.findAll().size();
        return "Reporte Excel generado con " + total + " asientos contables";
    }
}