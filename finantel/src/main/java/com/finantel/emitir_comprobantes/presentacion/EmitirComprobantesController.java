package com.finantel.emitir_comprobantes.presentacion;

import com.finantel.emitir_comprobantes.aplicacion.EmitirComprobantesService;
import com.finantel.emitir_comprobantes.infraestructura.mapping.AbstractComprobante;
import com.finantel.emitir_comprobantes.infraestructura.mapping.AbstractComprobanteFactory;
import com.finantel.emitir_comprobantes.infraestructura.mapping.AbstractFacturaFactory;
import com.finantel.emitir_comprobantes.infraestructura.mapping.AbstractBoletaFactory;
import com.finantel.emitir_comprobantes.dominio.entity.Comprobante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/comprobantes")
public class EmitirComprobantesController {

    private final EmitirComprobantesService service;

    public EmitirComprobantesController(EmitirComprobantesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Comprobante> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<?> emitir(@RequestBody Comprobante comprobante, Principal principal) {
        try {
            service.emitir(comprobante, principal.getName());
            return ResponseEntity.ok(java.util.Map.of("mensaje", 
                "Comprobante " + comprobante.getNumero() + " — " + comprobante.getTipo() + " emitido correctamente para " + comprobante.getCliente()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/abstract-factory/{tipo}")
    public ResponseEntity<String> emitirConAbstractFactory(
            @PathVariable(name = "tipo") String tipo, Principal principal) {

        AbstractComprobanteFactory factory;

        switch (tipo.toLowerCase()) {
            case "factura": factory = new AbstractFacturaFactory(); break;
            case "boleta":  factory = new AbstractBoletaFactory(); break;
            default: return ResponseEntity.badRequest().body("Tipo no soportado: " + tipo);
        }

        // 1. Abstract Factory crea el comprobante según el tipo
        AbstractComprobante abstractComprobante = factory.crearComprobante();

        // 2. Convierte a entidad real
        Comprobante comprobante = new Comprobante();
        comprobante.setNumero(abstractComprobante.getSerie() + "-" + System.currentTimeMillis());
        comprobante.setTipo(abstractComprobante.getTipo());
        comprobante.setCliente("Cliente FINANTEL");
        comprobante.setMonto(0.00);

        // 3. Guarda en BD usando el usuario autenticado
        service.emitir(comprobante, principal.getName());

        return ResponseEntity.ok(
            abstractComprobante.getPatron() +
            " | Fábrica: " + factory.getDescripcion() +
            " | Tipo: " + abstractComprobante.getTipo() +
            " | Serie: " + abstractComprobante.getSerie() +
            " | " + abstractComprobante.emitir() +
            " | GUARDADO EN BD "
        );
    }
}