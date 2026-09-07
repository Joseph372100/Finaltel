package com.finantel.emitir_comprobantes.infraestructura.mapping;

public class AbstractBoletaFactory implements AbstractComprobanteFactory {

    @Override
    public AbstractComprobante crearComprobante() {
        return new AbstractBoleta();
    }

    @Override
    public String getDescripcion() {
        return "Fábrica de Boletas — para consumidores finales";
    }
}