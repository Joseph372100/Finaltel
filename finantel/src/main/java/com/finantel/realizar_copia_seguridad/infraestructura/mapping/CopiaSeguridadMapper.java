package com.finantel.realizar_copia_seguridad.infraestructura.mapping;

import com.finantel.realizar_copia_seguridad.dominio.entity.CopiaSeguridadEntity;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class CopiaSeguridadMapper {

    public CopiaSeguridadEntity toCopia(String usuario, String tipo) {
        CopiaSeguridadEntity c = new CopiaSeguridadEntity();
        c.setUsuario(usuario);
        c.setTipo(tipo);
        c.setFecha(LocalDateTime.now());
        c.setEstado("Completado");
        c.setTamanio("2.5 GB");
        return c;
    }
}