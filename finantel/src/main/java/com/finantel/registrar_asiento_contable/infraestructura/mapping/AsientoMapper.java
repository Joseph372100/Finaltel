package com.finantel.registrar_asiento_contable.infraestructura.mapping;

import org.springframework.stereotype.Component;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;

@Component
public class AsientoMapper {

    public AsientoContable toEntity(String descripcion, String tipo, 
                                     Double debe, Double haber, String usuario) {
        AsientoContable a = new AsientoContable();
        a.setDescripcion(descripcion);
        a.setTipo(tipo);
        a.setDebe(debe);
        a.setHaber(haber);
        a.setUsuario(usuario);
        a.setEstado("Activo");
        return a;
    }
}