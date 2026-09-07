package com.finantel.exportar_reportes.dominio.repository;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExportarReportesRepository extends JpaRepository<AsientoContable, Integer> {
    List<AsientoContable> findByEstado(String estado);
}