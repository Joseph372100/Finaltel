package com.finantel.registrar_usuario.presentacion;

import com.finantel.registrar_usuario.aplicacion.UsuarioService;
import org.springframework.security.access.prepost.PreAuthorize;
import com.finantel.registrar_usuario.dominio.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<?> crear(@RequestBody Usuario u) {
        service.crear(u);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<?> actualizar(@PathVariable("id") Integer id,
                                         @RequestBody Map<String, String> body) {
        service.actualizar(id, body.get("nombre"), body.get("rol"), body.get("estado"));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/rol")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<?> cambiarRol(@PathVariable("id") Integer id,
                                         @RequestBody Map<String, String> body) {
        service.actualizarRol(id, body.get("rol"));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/estado")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<?> cambiarEstado(@PathVariable("id") Integer id,
                                            @RequestBody Map<String, String> body) {
        service.cambiarEstado(id, body.get("estado"));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMINISTRADOR')")
    public ResponseEntity<?> eliminar(@PathVariable("id") Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}