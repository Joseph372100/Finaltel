package com.finantel.ocr_documentos.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class OcrDocumentosConfig {

    public String getTesseractPath() {
        return "C:\\Users\\User\\AppData\\Local\\Programs\\Tesseract-OCR\\tessdata";
    }

    public boolean esFormatoValido(String nombre) {
        return nombre != null && (
            nombre.endsWith(".png") ||
            nombre.endsWith(".jpg") ||
            nombre.endsWith(".jpeg") ||
            nombre.endsWith(".pdf")
        );
    }
}