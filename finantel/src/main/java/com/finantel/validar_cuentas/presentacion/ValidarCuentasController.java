package com.finantel.validar_cuentas.presentacion;

import com.finantel.validar_cuentas.aplicacion.ValidarCuentasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validar-cuentas")
public class ValidarCuentasController {

    private final ValidarCuentasService service;

    public ValidarCuentasController(ValidarCuentasService service) {
        this.service = service;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> validar(@PathVariable("codigo") String codigo) {
        return ResponseEntity.ok(service.validarCuenta(codigo));
    }

    @GetMapping
    public ResponseEntity<?> listarActivas() {
        return ResponseEntity.ok(service.listarCuentasActivas());
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody com.finantel.validar_cuentas.dominio.entity.CuentaContable c) {
        try {
            service.crear(c);
            return ResponseEntity.ok(java.util.Map.of("mensaje", "Cuenta " + c.getCodigo() + " — " + c.getDescripcion() + " creada correctamente"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", e.getMessage()));
        }
    }
}