package com.finantel.ocr_documentos.dominio.repository;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcrDocumentosRepository extends JpaRepository<AsientoContable, Integer> {
}