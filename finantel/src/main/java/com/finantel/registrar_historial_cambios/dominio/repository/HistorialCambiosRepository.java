package com.finantel.registrar_historial_cambios.dominio.repository;

import com.finantel.registrar_historial_cambios.dominio.entity.HistorialCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistorialCambiosRepository extends JpaRepository<HistorialCambio, Integer> {
    List<HistorialCambio> findByUsuario(String usuario);
}