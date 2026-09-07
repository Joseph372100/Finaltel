package com.finantel.visualizar_reportes_graficos.dominio.repository;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReportesGraficosRepository extends JpaRepository<AsientoContable, Integer> {
    List<AsientoContable> findByTipo(String tipo);
}