package com.finantel.duplicar_asiento.aplicacion;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import com.finantel.registrar_asiento_contable.dominio.repository.AsientoContableRepository;
import org.springframework.stereotype.Service;

@Service
public class DuplicarAsientoService {

    private final AsientoContableRepository repo;
    private final AuditoriaService auditoriaService;

    public DuplicarAsientoService(AsientoContableRepository repo,
                                   AuditoriaService auditoriaService) {
        this.repo = repo;
        this.auditoriaService = auditoriaService;
    }

    public void duplicar(Integer id, String usuario) {
        AsientoContable original = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        AsientoContable copia = new AsientoContable();
        copia.setDescripcion("COPIA - " + original.getDescripcion());
        copia.setTipo(original.getTipo());
        copia.setDebe(original.getDebe());
        copia.setHaber(original.getHaber());
        copia.setEstado("Activo");
        copia.setUsuario(usuario);
        repo.save(copia);
        auditoriaService.registrar(
            usuario, "Duplicación", "AsientosContables",
            "Asiento #" + id, "COPIA - " + original.getDescripcion()
        );
    }
}