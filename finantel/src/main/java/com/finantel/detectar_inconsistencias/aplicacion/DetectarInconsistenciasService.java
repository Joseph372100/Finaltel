package com.finantel.detectar_inconsistencias.aplicacion;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import com.finantel.detectar_inconsistencias.dominio.repository.InconsistenciaRepository;
import com.finantel.detectar_inconsistencias.dominio.entity.Inconsistencia;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetectarInconsistenciasService {

    private final InconsistenciaRepository repo;

    public DetectarInconsistenciasService(InconsistenciaRepository repo) {
        this.repo = repo;
    }

    public String detectarErrores(Integer id) {
        AsientoContable a = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        if (Math.abs(a.getDebe() - a.getHaber()) > 0.01) {
            return "Error: El asiento no está balanceado. Debe: " + a.getDebe() + " Haber: " + a.getHaber();
        }
        return "Sin inconsistencias detectadas";
    }

    public List<Inconsistencia> detectarTodos() {
        List<AsientoContable> asientos = repo.findAll();
        List<Inconsistencia> errores = new ArrayList<>();
        for (AsientoContable a : asientos) {
            if (Math.abs(a.getDebe() - a.getHaber()) > 0.01) {
                errores.add(new Inconsistencia(
                    a.getId(),
                    "Desbalance contable",
                    "Debe: " + a.getDebe() + " - Haber: " + a.getHaber()
                ));
            }
        }
        return errores;
    }
}