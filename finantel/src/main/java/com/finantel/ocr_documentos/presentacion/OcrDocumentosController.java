package com.finantel.ocr_documentos.presentacion;

import com.finantel.ocr_documentos.aplicacion.OcrDocumentosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ocr")
public class OcrDocumentosController {

    private final OcrDocumentosService service;

    public OcrDocumentosController(OcrDocumentosService service) {
        this.service = service;
    }

    @PostMapping("/leer")
    public ResponseEntity<?> leerDocumento(@RequestParam("archivo") MultipartFile archivo) {
        try {
            String texto = service.extraerTexto(archivo);
            return ResponseEntity.ok(texto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al procesar el documento: " + e.getMessage());
        }
    }
}