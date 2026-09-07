package com.finantel.registrar_usuario.infraestructura.mapping;

import com.finantel.registrar_usuario.dominio.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(String nombre, String email, String rol) {
        Usuario u = new Usuario();
        u.setNombre(nombre);
        u.setEmail(email);
        u.setRol(rol);
        u.setEstado("Activo");
        u.setIntentos(0);
        return u;
    }
}