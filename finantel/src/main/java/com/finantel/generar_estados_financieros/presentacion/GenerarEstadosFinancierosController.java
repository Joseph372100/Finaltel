package com.finantel.generar_estados_financieros.presentacion;

import com.finantel.generar_estados_financieros.aplicacion.GenerarEstadosFinancierosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estados-financieros")
public class GenerarEstadosFinancierosController {

    private final GenerarEstadosFinancierosService service;

    public GenerarEstadosFinancierosController(GenerarEstadosFinancierosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> generar() {
        return ResponseEntity.ok(service.generarEstado());
    }
}