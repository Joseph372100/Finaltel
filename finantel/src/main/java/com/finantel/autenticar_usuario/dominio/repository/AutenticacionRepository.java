package com.finantel.autenticar_usuario.dominio.repository;
import com.finantel.registrar_usuario.dominio.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AutenticacionRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}