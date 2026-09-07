package com.finantel.realizar_copia_seguridad.aplicacion;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import com.finantel.realizar_copia_seguridad.dominio.entity.CopiaSeguridadEntity;
import com.finantel.realizar_copia_seguridad.dominio.repository.CopiaSeguridadRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RealizarCopiaSeguridadService {

    private final CopiaSeguridadRepository repo;
    private final AuditoriaService auditoriaService;

    public RealizarCopiaSeguridadService(CopiaSeguridadRepository repo,
                                          AuditoriaService auditoriaService) {
        this.repo = repo;
        this.auditoriaService = auditoriaService;
    }

    public String realizarCopia(String usuario) {
        CopiaSeguridadEntity copia = new CopiaSeguridadEntity();
        copia.setFecha(LocalDateTime.now());
        copia.setUsuario(usuario);
        copia.setTipo("Manual");
        copia.setEstado("Completado");
        copia.setTamanio("20mb");
        repo.save(copia);
        auditoriaService.registrar(
            usuario, "Copia de seguridad", "RespaldosBD",
            null, "Copia manual realizada"
        );
        return "Copia de seguridad realizada correctamente";
    }

    public List<CopiaSeguridadEntity> listar() {
        return repo.findAll();
    }
}