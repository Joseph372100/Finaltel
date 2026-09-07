package com.finantel.duplicar_asiento.presentacion;

import com.finantel.duplicar_asiento.aplicacion.DuplicarAsientoService;
import com.finantel.duplicar_asiento.infraestructura.mapping.PrototypeAsiento;
import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import com.finantel.registrar_asiento_contable.dominio.repository.AsientoContableRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("/duplicar-asiento")
public class DuplicarAsientoController {

    private final DuplicarAsientoService service;
    private final AsientoContableRepository repo;

    public DuplicarAsientoController(DuplicarAsientoService service,
                                      AsientoContableRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> duplicar(@PathVariable("id") Integer id, Principal principal) {
        service.duplicar(id, principal.getName());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/prototype/{id}")
    public ResponseEntity<String> prototipo(@PathVariable(name = "id") Integer id) {
        try {
            // 1. Obtiene el asiento original de la BD
            AsientoContable original = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado: " + id));

            // 2. Crea el prototipo con los datos reales
            PrototypeAsiento prototipo = new PrototypeAsiento(
                original.getNumeroCorrelativo(),
                original.getTipo(),
                original.getDescripcion(),
                original.getDebe(),
                original.getHaber(),
                original.getCuentaContable(),
                original.getUsuario(),
                original.getFechaRegistro() != null ? original.getFechaRegistro().toString() : "Sin fecha"
            	);

            // 3. Clona el prototipo
            PrototypeAsiento clon = prototipo.clonar("AS-CLON-" + id);

            // 4. Guarda el clon en la BD usando el service
            service.duplicar(id, original.getUsuario());

            return ResponseEntity.ok(
                "ORIGINAL: " + prototipo.toString() +
                " || CLON GUARDADO EN BD: " + clon.toString()
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}