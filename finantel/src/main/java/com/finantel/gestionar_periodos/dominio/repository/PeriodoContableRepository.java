package com.finantel.gestionar_periodos.dominio.repository;

import com.finantel.gestionar_periodos.dominio.entity.PeriodoContable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoContableRepository extends JpaRepository<PeriodoContable, Integer> {}