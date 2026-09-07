package com.finantel.tipo_cambio.dominio.repository;

import com.finantel.tipo_cambio.dominio.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {}