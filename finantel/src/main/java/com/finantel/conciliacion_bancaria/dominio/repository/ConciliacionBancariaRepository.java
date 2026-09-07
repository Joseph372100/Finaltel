package com.finantel.conciliacion_bancaria.dominio.repository;

import com.finantel.conciliacion_bancaria.dominio.entity.MovimientoBancario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConciliacionBancariaRepository extends JpaRepository<MovimientoBancario, Integer> {
    List<MovimientoBancario> findByEstado(String estado);
}