package com.finantel.inactivar_asiento.presentacion;

import com.finantel.inactivar_asiento.aplicacion.InactivarAsientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/inactivar-asiento")
public class InactivarAsientoController {

    private final InactivarAsientoService service;

    public InactivarAsientoController(InactivarAsientoService service) {
        this.service = service;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> inactivar(@PathVariable("id") Integer id, Principal principal) {
        service.inactivar(id);
        return ResponseEntity.ok().build();
    }
}