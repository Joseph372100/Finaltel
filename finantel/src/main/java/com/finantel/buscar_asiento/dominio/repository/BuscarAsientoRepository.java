package com.finantel.buscar_asiento.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;

import java.util.List;

public interface BuscarAsientoRepository extends JpaRepository<AsientoContable, Integer> {
    List<AsientoContable> findByTipo(String tipo);
    List<AsientoContable> findByUsuario(String usuario);
    List<AsientoContable> findByEstado(String estado);
}