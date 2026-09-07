package com.finantel.restaurar_base_datos.infraestructura.mapping;

import com.finantel.restaurar_base_datos.dominio.entity.PuntoRestauracion;
import org.springframework.stereotype.Component;

@Component
public class RestaurarBaseDatosMapper {

    public PuntoRestauracion toPunto(Integer id, String fecha, String tipo, String estado) {
        return new PuntoRestauracion(id, fecha, tipo, estado);
    }
}