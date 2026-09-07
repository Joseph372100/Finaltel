package com.finantel.registrar_asiento_contable.presentacion;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import com.finantel.registrar_asiento_contable.infraestructura.mapping.BuilderAsiento;
import com.finantel.registrar_asiento_contable.aplicacion.AsientoContableService;
import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/asientos")
public class AsientoContableController {

    private final AsientoContableService service;
    private final AuditoriaService auditoriaService;

    public AsientoContableController(AsientoContableService service,
                                      AuditoriaService auditoriaService) {
        this.service = service;
        this.auditoriaService = auditoriaService;
    }

    @GetMapping
    public List<AsientoContable> listar() {
        return service.listar();
    }
    @PostMapping("/builder")
    public ResponseEntity<String> construirAsiento(@RequestBody AsientoContable datos) {

        // 1. Construye con el patrón Builder usando los datos del usuario
        BuilderAsiento builderAsiento = new BuilderAsiento.Builder()
            .numeroCorrelativo(datos.getNumeroCorrelativo())
            .tipo(datos.getTipo())
            .descripcion(datos.getDescripcion())
            .debe(datos.getDebe())
            .haber(datos.getHaber())
            .cuentaContable(datos.getCuentaContable())
            .centroCosto(datos.getCentroCosto())
            .moneda(datos.getMoneda() != null ? datos.getMoneda() : "PEN")
            .tipoCambio(datos.getTipoCambio() != null ? datos.getTipoCambio() : 1.0)
            .usuario(datos.getUsuario())
            .build();

        // 2. Convierte a entidad real
        AsientoContable asiento = new AsientoContable();
        asiento.setNumeroCorrelativo(builderAsiento.getNumeroCorrelativo());
        asiento.setTipo(builderAsiento.getTipo());
        asiento.setDescripcion(builderAsiento.getDescripcion());
        asiento.setDebe(builderAsiento.getDebe());
        asiento.setHaber(builderAsiento.getHaber());
        asiento.setCuentaContable(builderAsiento.getCuentaContable());
        asiento.setCentroCosto(builderAsiento.getCentroCosto());
        asiento.setMoneda(builderAsiento.getMoneda());
        asiento.setTipoCambio(builderAsiento.getTipoCambio());
        asiento.setUsuario(builderAsiento.getUsuario());

        // 3. Guarda en BD
        service.crear(asiento);

        return ResponseEntity.ok(builderAsiento.toString() + " |GUARDADO EN BD ");
    }
    @GetMapping("/{id}")
    public AsientoContable buscar(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id,
                                         @RequestBody AsientoContable datos,
                                         Principal principal) {
        AsientoContable anterior = service.buscarPorId(id);
        String valAnterior = anterior.getTipo() + ": " + anterior.getDescripcion();
        service.actualizar(id, datos);
        auditoriaService.registrar(principal.getName(), "Edición",
            "Asiento #" + id, valAnterior,
            datos.getTipo() + ": " + datos.getDescripcion());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/anular/{id}")
    public ResponseEntity<?> anular(@PathVariable Integer id, Principal principal) {
        AsientoContable a = service.buscarPorId(id);
        service.anular(id);
        auditoriaService.registrar(principal.getName(), "Anulación",
            "Asiento #" + id, "Activo", "Anulado");
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody AsientoContable a, Principal principal) {
        try {
            a.setUsuario(principal.getName());
            service.crear(a);
            auditoriaService.registrar(principal.getName(), "Creación",
                "Asiento", "—", a.getDescripcion());
            return ResponseEntity.ok().build();
        } catch (org.springframework.http.converter.HttpMessageNotReadableException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error",
                "Los campos 'debe' y 'haber' deben ser números. Ejemplo: 5000 o 5000.50"));
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error",
                "La cuenta contable '" + a.getCuentaContable() + "' no existe en el Plan de Cuentas. Cuentas válidas: 1011, 2011, 3011, 4011, 4501, 5011"));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", e.getMessage()));
        }
    }
    
}