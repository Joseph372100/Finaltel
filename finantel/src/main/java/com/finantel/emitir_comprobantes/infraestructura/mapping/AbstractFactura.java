package com.finantel.emitir_comprobantes.infraestructura.mapping;

public class AbstractFactura implements AbstractComprobante {

    @Override
    public String emitir() {
        return "Factura emitida con IGV 18% — FINANTEL S.A.C.";
    }

    @Override
    public String getTipo() { return "Factura"; }

    @Override
    public String getSerie() { return "F001"; }

    @Override
    public String getPatron() { return "Patrón Abstract Factory — AbstractFactura"; }
}