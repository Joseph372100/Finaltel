package com.finantel.restaurar_base_datos.dominio.repository;

import com.finantel.realizar_copia_seguridad.dominio.entity.CopiaSeguridadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestaurarBaseDatosRepository extends JpaRepository<CopiaSeguridadEntity, Integer> {
    List<CopiaSeguridadEntity> findByEstado(String estado);
}