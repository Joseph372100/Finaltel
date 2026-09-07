package com.finantel.emitir_comprobantes.infraestructura.mapping;

public class AbstractFacturaFactory implements AbstractComprobanteFactory {

    @Override
    public AbstractComprobante crearComprobante() {
        return new AbstractFactura();
    }

    @Override
    public String getDescripcion() {
        return "Fábrica de Facturas — para empresas con RUC";
    }
}