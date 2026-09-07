package com.finantel.registrar_usuario.dominio.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finantel.registrar_usuario.dominio.entity.Usuario;

import java.util.Optional;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}