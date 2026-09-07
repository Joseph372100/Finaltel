package com.finantel.realizar_copia_seguridad.dominio.repository;

import com.finantel.realizar_copia_seguridad.dominio.entity.CopiaSeguridadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CopiaSeguridadRepository extends JpaRepository<CopiaSeguridadEntity, Integer> {
    List<CopiaSeguridadEntity> findByUsuario(String usuario);
    List<CopiaSeguridadEntity> findByTipo(String tipo);
}