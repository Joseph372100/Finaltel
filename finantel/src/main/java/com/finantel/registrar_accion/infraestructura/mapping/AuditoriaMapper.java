package com.finantel.registrar_accion.infraestructura.mapping;

import com.finantel.registrar_accion.dominio.entity.AuditoriaAccion;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class AuditoriaMapper {

    public AuditoriaAccion toEntity(String usuario, String accion, 
                                    String objeto, String anterior, String nuevo) {
        AuditoriaAccion a = new AuditoriaAccion();
        a.setFecha(LocalDateTime.now());
        a.setUsuario(usuario);
        a.setAccion(accion);
        a.setObjeto(objeto);
        a.setValorAnterior(anterior);
        a.setValorNuevo(nuevo);
        return a;
    }
}