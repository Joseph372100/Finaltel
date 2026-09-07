package com.finantel.inactivar_asiento.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;

import java.util.List;

public interface InactivarAsientoRepository extends JpaRepository<AsientoContable, Integer> {
    List<AsientoContable> findByEstado(String estado);
}