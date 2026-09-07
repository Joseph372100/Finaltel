package com.finantel.restaurar_base_datos.aplicacion;

import com.finantel.realizar_copia_seguridad.dominio.entity.CopiaSeguridadEntity;
import com.finantel.restaurar_base_datos.dominio.repository.RestaurarBaseDatosRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurarBaseDatosService {

    private final RestaurarBaseDatosRepository repo;

    public RestaurarBaseDatosService(RestaurarBaseDatosRepository repo) {
        this.repo = repo;
    }

    public String restaurar(Integer id, String usuario) {
        return repo.findById(id)
            .map(c -> "Base de datos restaurada al punto: " + c.getFecha() + " por " + usuario)
            .orElse("Punto de restauración no encontrado");
    }

    public List<CopiaSeguridadEntity> listarPuntos() {
        return repo.findAll();
    }
}