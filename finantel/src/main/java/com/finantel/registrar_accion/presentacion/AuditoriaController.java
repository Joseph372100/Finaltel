package com.finantel.registrar_accion.presentacion;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import com.finantel.registrar_accion.dominio.entity.AuditoriaAccion;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
	@RequestMapping("/auditoria")
public class AuditoriaController {

    private final AuditoriaService service;

    public AuditoriaController(AuditoriaService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRADOR', 'ROLE_AUDITOR')")
    public List<AuditoriaAccion> listar(
            @RequestParam(name = "usuario", required = false) String usuario,
            @RequestParam(name = "accion", required = false) String accion) {
        if (usuario != null && !usuario.isEmpty())
            return service.filtrarPorUsuario(usuario);
        if (accion != null && !accion.isEmpty())
            return service.filtrarPorAccion(accion);
        return service.listar();
    }
}