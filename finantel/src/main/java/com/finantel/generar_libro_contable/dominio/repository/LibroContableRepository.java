package com.finantel.generar_libro_contable.dominio.repository;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroContableRepository extends JpaRepository<AsientoContable, Integer> {
    List<AsientoContable> findByEstado(String estado);
}