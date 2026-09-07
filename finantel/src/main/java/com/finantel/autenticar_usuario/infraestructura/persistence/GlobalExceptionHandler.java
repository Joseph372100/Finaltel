package com.finantel.autenticar_usuario.infraestructura.persistence;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
            .badRequest()
            .body(Map.of("error", ex.getMessage()));
    }
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonError(org.springframework.http.converter.HttpMessageNotReadableException e, 
            jakarta.servlet.http.HttpServletRequest request) {
        String msg = e.getMessage() != null ? e.getMessage() : "";
        String uri = request.getRequestURI();
        
        if (msg.contains("LocalDate") || msg.contains("fecha"))
            return ResponseEntity.badRequest().body(java.util.Map.of("error",
                "Formato de fecha inválido. Use: YYYY-MM-DD. Ejemplo: fechaInicio=2026-07-01"));
        
        if (uri.contains("comprobantes"))
            return ResponseEntity.badRequest().body(java.util.Map.of("error",
                "El campo 'monto' debe ser un número. Ejemplo: monto=1500.00"));
        
        if (uri.contains("asientos"))
            return ResponseEntity.badRequest().body(java.util.Map.of("error",
                "Formato inválido. Los campos debe, haber y tipoCambio deben ser números. Ejemplo: debe=5000, haber=5000, tipoCambio=1.0"));
        
        return ResponseEntity.badRequest().body(java.util.Map.of("error",
            "Formato de datos inválido. Verifica que los campos numéricos sean números válidos."));
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDenied(AccessDeniedException e) {
        return ResponseEntity.status(403).body(Map.of("error", "Acceso denegado — Solo el Administrador puede realizar esta operación"));
    }
}