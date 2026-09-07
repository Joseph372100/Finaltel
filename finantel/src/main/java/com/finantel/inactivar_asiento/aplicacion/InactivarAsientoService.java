package com.finantel.inactivar_asiento.aplicacion;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import com.finantel.registrar_asiento_contable.dominio.repository.AsientoContableRepository;
import org.springframework.stereotype.Service;

@Service
public class InactivarAsientoService {

    private final AsientoContableRepository repo;
    private final AuditoriaService auditoriaService;

    public InactivarAsientoService(AsientoContableRepository repo,
                                    AuditoriaService auditoriaService) {
        this.repo = repo;
        this.auditoriaService = auditoriaService;
    }

    public void inactivar(Integer id) {
        AsientoContable a = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        if ("Cerrado".equalsIgnoreCase(a.getEstado())) {
            throw new RuntimeException("No se puede inactivar un asiento en periodo cerrado");
        }
        String anterior = a.getEstado();
        a.setEstado("Inactivo");
        repo.save(a);
        auditoriaService.registrar(
            a.getUsuario(), "Inactivación", "AsientosContables",
            anterior, "Inactivo"
        );
    }
}