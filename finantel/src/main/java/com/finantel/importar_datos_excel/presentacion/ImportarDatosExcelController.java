package com.finantel.importar_datos_excel.presentacion;

import com.finantel.importar_datos_excel.aplicacion.ImportarDatosExcelService;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/web/importar-excel")
public class ImportarDatosExcelController {

    private final ImportarDatosExcelService service;

    public ImportarDatosExcelController(ImportarDatosExcelService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> importar(@RequestParam("archivo") MultipartFile archivo,
                                       Authentication authentication) {
        return ResponseEntity.ok(service.importar(archivo, authentication.getName()));
    }
}