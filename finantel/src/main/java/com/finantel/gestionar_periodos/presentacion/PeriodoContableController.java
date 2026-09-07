package com.finantel.gestionar_periodos.presentacion;

import com.finantel.gestionar_periodos.aplicacion.PeriodoContableService;
import com.finantel.gestionar_periodos.dominio.entity.PeriodoContable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/periodos-contables")
public class PeriodoContableController {

    private final PeriodoContableService service;

    public PeriodoContableController(PeriodoContableService service) {
        this.service = service;
    }

    @GetMapping
    public List<PeriodoContable> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PeriodoContable p) {
        try {
            service.crear(p);
            return ResponseEntity.ok(java.util.Map.of("mensaje", "Periodo '" + p.getPeriodo() + "' creado correctamente"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", e.getMessage()));
        }
    }

    @PatchMapping("/{id}/cerrar")
    public ResponseEntity<?> cerrar(@PathVariable Integer id, Principal principal) {
        try {
            service.cerrar(id, principal.getName());
            return ResponseEntity.ok(java.util.Map.of("mensaje", "Periodo cerrado correctamente"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", e.getMessage()));
        }
    }
}