package com.finantel.visualizar_reportes_graficos.aplicacion;

import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import com.finantel.visualizar_reportes_graficos.dominio.repository.ReportesGraficosRepository;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VisualizarReportesGraficosService {

    private final ReportesGraficosRepository repo;

    public VisualizarReportesGraficosService(ReportesGraficosRepository repo) {
        this.repo = repo;
    }

    public Map<String, Object> generarResumen() {
        var asientos = repo.findAll();
        double totalDebe = asientos.stream().mapToDouble(a -> a.getDebe() != null ? a.getDebe() : 0).sum();
        double totalHaber = asientos.stream().mapToDouble(a -> a.getHaber() != null ? a.getHaber() : 0).sum();
        return Map.of(
            "totalAsientos", asientos.size(),
            "totalDebe", totalDebe,
            "totalHaber", totalHaber,
            "resultado", totalHaber - totalDebe
        );
    }

    public Map<String, Long> agruparPorTipo() {
        return repo.findAll().stream()
            .collect(Collectors.groupingBy(
                a -> a.getTipo() != null ? a.getTipo() : "Sin tipo",
                Collectors.counting()
            ));
    }
}