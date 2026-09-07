package com.finantel.registrar_historial_cambios.aplicacion;

import com.finantel.registrar_historial_cambios.dominio.entity.HistorialCambio;
import com.finantel.registrar_historial_cambios.dominio.repository.HistorialCambiosRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrarHistorialCambiosService {

    private final HistorialCambiosRepository repo;

    public RegistrarHistorialCambiosService(HistorialCambiosRepository repo) {
        this.repo = repo;
    }

    public void registrar(String usuario, String campo, String anterior, String nuevo) {
        HistorialCambio h = new HistorialCambio();
        h.setUsuario(usuario);
        h.setCampo(campo);
        h.setValorAnterior(anterior);
        h.setValorNuevo(nuevo);
        h.setFecha(LocalDateTime.now());
        repo.save(h);
    }

    public List<HistorialCambio> listar() {
        return repo.findAll();
    }
}