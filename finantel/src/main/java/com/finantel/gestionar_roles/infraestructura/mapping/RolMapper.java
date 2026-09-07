package com.finantel.gestionar_roles.infraestructura.mapping;

import com.finantel.gestionar_roles.dominio.entity.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {

    public Rol toRol(String nombre, String descripcion) {
        return new Rol(nombre, descripcion);
    }
}