package com.finantel.gestionar_periodos.aplicacion;

import com.finantel.gestionar_periodos.dominio.entity.PeriodoContable;
import com.finantel.gestionar_periodos.dominio.repository.PeriodoContableRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeriodoContableService {
    private final PeriodoContableRepository repo;

    public PeriodoContableService(PeriodoContableRepository repo) {
        this.repo = repo;
    }

    public List<PeriodoContable> listar() {
        return repo.findAll();
    }

    public void crear(PeriodoContable p) {
        p.setEstado("Activo");
        repo.save(p);
    }

    public void cerrar(Integer id, String usuario) {
        PeriodoContable p = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Periodo no encontrado"));
        p.setEstado("Cerrado");
        p.setCerradoPor(usuario);
        repo.save(p);
    }
}