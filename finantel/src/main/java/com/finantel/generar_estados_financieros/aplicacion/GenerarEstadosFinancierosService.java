package com.finantel.generar_estados_financieros.aplicacion;

import com.finantel.generar_estados_financieros.dominio.repository.EstadosFinancierosRepository;
import org.springframework.stereotype.Service;

@Service
public class GenerarEstadosFinancierosService {

    private final EstadosFinancierosRepository repo;

    public GenerarEstadosFinancierosService(EstadosFinancierosRepository repo) {
        this.repo = repo;
    }

    public String generarEstado() {
        double totalDebe = repo.findAll().stream()
            .mapToDouble(a -> a.getDebe() != null ? a.getDebe() : 0)
            .sum();
        double totalHaber = repo.findAll().stream()
            .mapToDouble(a -> a.getHaber() != null ? a.getHaber() : 0)
            .sum();
        return "Total Debe: " + totalDebe + " | Total Haber: " + totalHaber + " | Resultado: " + (totalHaber - totalDebe);
    }
}