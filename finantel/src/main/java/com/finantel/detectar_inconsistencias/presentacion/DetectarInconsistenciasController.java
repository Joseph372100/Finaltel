package com.finantel.detectar_inconsistencias.presentacion;

import com.finantel.detectar_inconsistencias.aplicacion.DetectarInconsistenciasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inconsistencias")
public class DetectarInconsistenciasController {

    private final DetectarInconsistenciasService service;

    public DetectarInconsistenciasController(DetectarInconsistenciasService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detectar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.detectarErrores(id));
    }

    @GetMapping
    public ResponseEntity<?> detectarTodos() {
        return ResponseEntity.ok(service.detectarTodos());
    }
}