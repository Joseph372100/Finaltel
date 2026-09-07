package com.finantel.emitir_comprobantes.infraestructura.mapping;

public class AbstractBoleta implements AbstractComprobante {

    @Override
    public String emitir() {
        return "Boleta emitida para consumidor final — FINANTEL S.A.C.";
    }

    @Override
    public String getTipo() { return "Boleta"; }

    @Override
    public String getSerie() { return "B001"; }

    @Override
    public String getPatron() { return "Patrón Abstract Factory — AbstractBoleta"; }
}