package com.finantel.conciliacion_bancaria.infraestructura.mapping;

import com.finantel.conciliacion_bancaria.dominio.entity.MovimientoBancario;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class ConciliacionBancariaMapper {

    public MovimientoBancario toMovimiento(String descripcion, Double monto, String tipo) {
        MovimientoBancario m = new MovimientoBancario();
        m.setDescripcion(descripcion);
        m.setMonto(monto);
        m.setTipo(tipo);
        m.setFecha(LocalDate.now());
        m.setEstado("Pendiente");
        return m;
    }
}