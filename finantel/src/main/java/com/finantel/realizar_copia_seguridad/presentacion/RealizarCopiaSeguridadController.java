package com.finantel.realizar_copia_seguridad.presentacion;

import com.finantel.realizar_copia_seguridad.aplicacion.RealizarCopiaSeguridadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/copia-seguridad")
public class RealizarCopiaSeguridadController {

    private final RealizarCopiaSeguridadService service;

    public RealizarCopiaSeguridadController(RealizarCopiaSeguridadService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> realizar(Principal principal) {
        return ResponseEntity.ok(service.realizarCopia(principal.getName()));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }
}