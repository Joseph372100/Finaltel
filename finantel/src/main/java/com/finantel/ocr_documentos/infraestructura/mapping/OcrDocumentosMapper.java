package com.finantel.ocr_documentos.infraestructura.mapping;

import com.finantel.ocr_documentos.dominio.entity.DocumentoOcr;
import org.springframework.stereotype.Component;

@Component
public class OcrDocumentosMapper {

    public DocumentoOcr toDocumento(String nombre, String texto) {
        return new DocumentoOcr(nombre, texto, "Procesado");
    }
}