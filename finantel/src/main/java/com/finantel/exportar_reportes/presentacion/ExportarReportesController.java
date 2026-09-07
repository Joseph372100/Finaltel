package com.finantel.exportar_reportes.presentacion;

import com.finantel.exportar_reportes.aplicacion.ExportarReportesService;
import com.finantel.exportar_reportes.infraestructura.mapping.FactoryReporte;
import com.finantel.exportar_reportes.infraestructura.mapping.FactoryReporteCreador;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exportar-reportes")
public class ExportarReportesController {

    private final ExportarReportesService service;

    public ExportarReportesController(ExportarReportesService service) {
        this.service = service;
    }

    @GetMapping("/pdf")
    public ResponseEntity<?> exportarPDF() {
        return ResponseEntity.ok(service.exportarPDF());
    }

    @GetMapping("/excel")
    public ResponseEntity<?> exportarExcel() {
        return ResponseEntity.ok(service.exportarExcel());
    }
    @GetMapping("/factory/{tipo}")
    public ResponseEntity<String> exportarConFactory(@PathVariable(name = "tipo") String tipo) {
        try {
            // 1. Factory Method crea el reporte según el tipo
            FactoryReporte reporte = FactoryReporteCreador.crearReporte(tipo);

            // 2. Usa el service real para obtener datos de la BD
            String resultado;
            if (tipo.equalsIgnoreCase("pdf")) {
                resultado = service.exportarPDF();
            } else {
                resultado = service.exportarExcel();
            }

            return ResponseEntity.ok(
                reporte.getPatron() +
                " | Tipo: " + reporte.getTipo() +
                " | " + resultado
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}