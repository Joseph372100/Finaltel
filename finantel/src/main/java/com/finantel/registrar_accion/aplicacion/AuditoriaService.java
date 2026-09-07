package com.finantel.registrar_accion.aplicacion;

import com.finantel.registrar_accion.dominio.entity.AuditoriaAccion;
import com.finantel.registrar_accion.dominio.repository.AuditoriaRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditoriaService {

    private final AuditoriaRepository repo;

    public AuditoriaService(AuditoriaRepository repo) {
        this.repo = repo;
    }

    public void registrar(String usuario, String accion, String objeto,
                          String valorAnterior, String valorNuevo) {
        AuditoriaAccion a = new AuditoriaAccion();
        a.setFecha(LocalDateTime.now());
        a.setUsuario(usuario);
        a.setAccion(accion);
        a.setObjeto(objeto);
        a.setValorAnterior(valorAnterior);
        a.setValorNuevo(valorNuevo);
        repo.save(a);
    }

    public List<AuditoriaAccion> listar() {
        return repo.findAll();
    }

    public List<AuditoriaAccion> filtrarPorUsuario(String usuario) {
        return repo.findByUsuario(usuario);
    }

    public List<AuditoriaAccion> filtrarPorAccion(String accion) {
        return repo.findByAccion(accion);
    }
}