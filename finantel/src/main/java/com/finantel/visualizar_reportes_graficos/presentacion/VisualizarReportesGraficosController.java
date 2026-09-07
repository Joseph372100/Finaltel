package com.finantel.visualizar_reportes_graficos.presentacion;

import com.finantel.visualizar_reportes_graficos.aplicacion.VisualizarReportesGraficosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reportes-graficos")
public class VisualizarReportesGraficosController {

    private final VisualizarReportesGraficosService service;

    public VisualizarReportesGraficosController(VisualizarReportesGraficosService service) {
        this.service = service;
    }

    @GetMapping("/resumen")
    public ResponseEntity<?> resumen() {
        return ResponseEntity.ok(service.generarResumen());
    }

    @GetMapping("/por-tipo")
    public ResponseEntity<?> porTipo() {
        return ResponseEntity.ok(service.agruparPorTipo());
    }
}