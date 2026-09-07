package com.finantel.detectar_inconsistencias.dominio.repository;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InconsistenciaRepository extends JpaRepository<AsientoContable, Integer> {
    List<AsientoContable> findByEstado(String estado);
}