package com.finantel.registrar_historial_cambios.presentacion;

import com.finantel.registrar_historial_cambios.aplicacion.RegistrarHistorialCambiosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/historial-cambios")
public class RegistrarHistorialCambiosController {

    private final RegistrarHistorialCambiosService service;

    public RegistrarHistorialCambiosController(RegistrarHistorialCambiosService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody HistorialCambioRequest request) {
        service.registrar(request.getUsuario(), request.getCampo(), request.getAnterior(), request.getNuevo());
        return ResponseEntity.ok().build();
    }
}

class HistorialCambioRequest {
    private String usuario;
    private String campo;
    private String anterior;
    private String nuevo;

    public String getUsuario() { return usuario; }
    public String getCampo() { return campo; }
    public String getAnterior() { return anterior; }
    public String getNuevo() { return nuevo; }
    public void setUsuario(String u) { this.usuario = u; }
    public void setCampo(String c) { this.campo = c; }
    public void setAnterior(String a) { this.anterior = a; }
    public void setNuevo(String n) { this.nuevo = n; }
}