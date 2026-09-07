package com.finantel.emitir_comprobantes.dominio.repository;

import com.finantel.emitir_comprobantes.dominio.entity.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmitirComprobantesRepository extends JpaRepository<Comprobante, Integer> {
    List<Comprobante> findByEstado(String estado);
}