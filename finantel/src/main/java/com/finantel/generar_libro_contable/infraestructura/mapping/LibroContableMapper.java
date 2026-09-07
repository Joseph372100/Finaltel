package com.finantel.generar_libro_contable.infraestructura.mapping;

import com.finantel.generar_libro_contable.dominio.entity.LibroContable;
import org.springframework.stereotype.Component;

@Component
public class LibroContableMapper {

    public LibroContable toLibro(String periodo, Integer total, Double debe, Double haber) {
        return new LibroContable(periodo, total, debe, haber);
    }
}