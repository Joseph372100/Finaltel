package com.finantel.duplicar_asiento.dominio.repository;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DuplicarAsientoRepository extends JpaRepository<AsientoContable, Integer> {
    List<AsientoContable> findByDescripcionContaining(String texto);
}