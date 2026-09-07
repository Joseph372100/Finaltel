package com.finantel.restaurar_base_datos.presentacion;

import com.finantel.restaurar_base_datos.aplicacion.RestaurarBaseDatosService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/restaurar-bd")
public class RestaurarBaseDatosController {

    private final RestaurarBaseDatosService service;

    public RestaurarBaseDatosController(RestaurarBaseDatosService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<?> restaurar(@PathVariable("id") Integer id, Principal principal) {
        return ResponseEntity.ok(service.restaurar(id, principal.getName()));
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<?> listarPuntos() {
        return ResponseEntity.ok(service.listarPuntos());
    }
}