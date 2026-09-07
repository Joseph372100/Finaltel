package com.finantel.generar_libro_contable.presentacion;

import com.finantel.generar_libro_contable.aplicacion.GenerarLibroContableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libro-contable")
public class GenerarLibroContableController {

    private final GenerarLibroContableService service;

    public GenerarLibroContableController(GenerarLibroContableService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> generar() {
        return ResponseEntity.ok(service.generarLibro());
    }
}