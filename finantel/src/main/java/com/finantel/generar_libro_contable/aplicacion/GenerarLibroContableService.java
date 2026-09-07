package com.finantel.generar_libro_contable.aplicacion;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import com.finantel.generar_libro_contable.dominio.repository.LibroContableRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenerarLibroContableService {

    private final LibroContableRepository repo;

    public GenerarLibroContableService(LibroContableRepository repo) {
        this.repo = repo;
    }

    public List<AsientoContable> generarLibro() {
        return repo.findAll();
    }
}