package com.finantel.registrar_accion.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finantel.registrar_accion.dominio.entity.AuditoriaAccion;

import java.util.List;

public interface AuditoriaRepository extends JpaRepository<AuditoriaAccion, Integer> {
    List<AuditoriaAccion> findByUsuario(String usuario);
    List<AuditoriaAccion> findByAccion(String accion);
}