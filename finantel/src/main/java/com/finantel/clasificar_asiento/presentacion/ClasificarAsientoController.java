package com.finantel.clasificar_asiento.presentacion;

import com.finantel.clasificar_asiento.aplicacion.ClasificarAsientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clasificar-asiento")
public class ClasificarAsientoController {

    private final ClasificarAsientoService service;

    public ClasificarAsientoController(ClasificarAsientoService service) {
        this.service = service;
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<?> listarPorTipo(@PathVariable("tipo") String tipo) {
        return ResponseEntity.ok(service.listarPorTipo(tipo));
    }

    @GetMapping("/tipos")
    public ResponseEntity<List<String>> getTipos() {
        return ResponseEntity.ok(service.getTiposDisponibles());
    }
}