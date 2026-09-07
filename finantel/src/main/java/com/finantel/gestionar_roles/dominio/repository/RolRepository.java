package com.finantel.gestionar_roles.dominio.repository;

import com.finantel.registrar_usuario.dominio.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RolRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByRol(String rol);
}