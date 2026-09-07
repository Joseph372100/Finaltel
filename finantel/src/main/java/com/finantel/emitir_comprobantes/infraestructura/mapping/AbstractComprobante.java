package com.finantel.emitir_comprobantes.infraestructura.mapping;

/**
 * PATRÓN DE DISEÑO: Abstract Factory
 * Producto abstracto — define el contrato para los comprobantes.
 */
public interface AbstractComprobante {
    String emitir();
    String getTipo();
    String getSerie();
    String getPatron();
}