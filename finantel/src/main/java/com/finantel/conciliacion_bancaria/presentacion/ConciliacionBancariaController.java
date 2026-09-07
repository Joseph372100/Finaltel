package com.finantel.conciliacion_bancaria.presentacion;

import com.finantel.conciliacion_bancaria.aplicacion.ConciliacionBancariaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/conciliacion")
public class ConciliacionBancariaController {

    private final ConciliacionBancariaService service;

    public ConciliacionBancariaController(ConciliacionBancariaService service) {
        this.service = service;
    }

    @PostMapping("/comparar")
    public ResponseEntity<?> comparar(@RequestParam("extracto") MultipartFile extracto) {
        return ResponseEntity.ok(service.conciliar(extracto.getOriginalFilename()));
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listarMovimientos());
    }
}