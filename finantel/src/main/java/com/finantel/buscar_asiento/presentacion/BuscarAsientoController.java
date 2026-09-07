package com.finantel.buscar_asiento.presentacion;

import com.finantel.buscar_asiento.aplicacion.BuscarAsientoService;
import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/buscar-asiento")
public class BuscarAsientoController {

    private final BuscarAsientoService service;

    public BuscarAsientoController(BuscarAsientoService service) {
        this.service = service;
    }

    @GetMapping("/tipo/{tipo}")
    public List<AsientoContable> buscarPorTipo(@PathVariable("tipo") String tipo) {
        return service.buscarPorTipo(tipo);
    }

    @GetMapping("/usuario/{usuario}")
    public List<AsientoContable> buscarPorUsuario(@PathVariable("usuario") String usuario) {
        return service.buscarPorUsuario(usuario);
    }

    @GetMapping("/estado/{estado}")
    public List<AsientoContable> buscarPorEstado(@PathVariable("estado") String estado) {
        return service.buscarPorEstado(estado);
    }
}