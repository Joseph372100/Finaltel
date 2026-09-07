package com.finantel.importar_datos_excel.infraestructura.persistence;

import org.springframework.stereotype.Component;

@Component
public class ImportarDatosExcelConfig {

    public boolean esFormatoValido(String nombre) {
        return nombre != null && (nombre.endsWith(".xlsx") || nombre.endsWith(".xls"));
    }
}