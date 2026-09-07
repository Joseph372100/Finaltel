package com.finantel.autenticar_usuario.infraestructura.mapping;

import com.finantel.autenticar_usuario.dominio.entity.Credencial;
import org.springframework.stereotype.Component;

@Component
public class AutenticacionMapper {

    public Credencial toCredencial(String email, String password) {
        return new Credencial(email, password);
    }
}