package com.finantel.autenticar_usuario.presentacion;

import com.finantel.autenticar_usuario.infraestructura.persistence.SingletonConfiguracionSistema;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuracion")
public class ConfiguracionController {

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<String> getConfiguracion() {
        return ResponseEntity.ok(SingletonConfiguracionSistema.getInstancia().getResumen());
    }

    @GetMapping("/instancia")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<String> verificarInstancia() {
        SingletonConfiguracionSistema c1 = SingletonConfiguracionSistema.getInstancia();
        SingletonConfiguracionSistema c2 = SingletonConfiguracionSistema.getInstancia();
        return ResponseEntity.ok(
            "¿Es la misma instancia? " + (c1 == c2) +
            " | HashCode 1: " + c1.hashCode() +
            " | HashCode 2: " + c2.hashCode()
        );
    }
}