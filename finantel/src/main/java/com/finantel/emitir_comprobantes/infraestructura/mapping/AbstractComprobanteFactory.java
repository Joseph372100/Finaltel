package com.finantel.emitir_comprobantes.infraestructura.mapping;

public interface AbstractComprobanteFactory {
    AbstractComprobante crearComprobante();
    String getDescripcion();
}