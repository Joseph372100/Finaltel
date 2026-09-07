package com.finantel.clasificar_asiento.aplicacion;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import com.finantel.registrar_asiento_contable.dominio.repository.AsientoContableRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClasificarAsientoService {

    private final AsientoContableRepository repo;

    public ClasificarAsientoService(AsientoContableRepository repo) {
        this.repo = repo;
    }

    public List<AsientoContable> listarPorTipo(String tipo) {
        return repo.findAll().stream()
            .filter(a -> tipo.equalsIgnoreCase(a.getTipo()))
            .toList();
    }

    public List<String> getTiposDisponibles() {
        return List.of(
            "Apertura",
            "Operación ordinaria",
            "Ajuste",
            "Cierre",
            "Reversión"
        );
    }
}