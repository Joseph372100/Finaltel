package com.finantel.exportar_reportes.infraestructura.mapping;

/**
 * PATRÓN DE DISEÑO: Factory Method
 * Define el contrato para crear reportes exportables.
 */
public interface FactoryReporte {
    String generar();
    String getTipo();
    String getPatron();
}