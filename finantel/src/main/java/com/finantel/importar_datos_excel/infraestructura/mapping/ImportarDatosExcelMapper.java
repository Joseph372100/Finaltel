package com.finantel.importar_datos_excel.infraestructura.mapping;

import com.finantel.importar_datos_excel.dominio.entity.ArchivoExcel;
import org.springframework.stereotype.Component;

@Component
public class ImportarDatosExcelMapper {

    public ArchivoExcel toArchivo(String nombre, Long tamanio) {
        return new ArchivoExcel(nombre, tamanio, "Procesado");
    }
}