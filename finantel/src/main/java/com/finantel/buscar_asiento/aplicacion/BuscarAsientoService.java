package com.finantel.buscar_asiento.aplicacion;

import com.finantel.buscar_asiento.dominio.repository.BuscarAsientoRepository;
import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BuscarAsientoService {

    private final BuscarAsientoRepository repo;

    public BuscarAsientoService(BuscarAsientoRepository repo) {
        this.repo = repo;
    }

    public List<AsientoContable> buscarPorTipo(String tipo) {
        return repo.findByTipo(tipo);
    }

    public List<AsientoContable> buscarPorUsuario(String usuario) {
        return repo.findByUsuario(usuario);
    }

    public List<AsientoContable> buscarPorEstado(String estado) {
        return repo.findByEstado(estado);
    }
}