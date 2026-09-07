package com.finantel.registrar_historial_cambios.infraestructura.mapping;

import com.finantel.registrar_historial_cambios.dominio.entity.HistorialCambio;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class HistorialCambiosMapper {

    public HistorialCambio toHistorial(String usuario, String campo, String anterior, String nuevo) {
        HistorialCambio h = new HistorialCambio();
        h.setUsuario(usuario);
        h.setCampo(campo);
        h.setValorAnterior(anterior);
        h.setValorNuevo(nuevo);
        h.setFecha(LocalDateTime.now());
        return h;
    }
}