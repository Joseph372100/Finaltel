package com.finantel.emitir_comprobantes.infraestructura.mapping;

import com.finantel.emitir_comprobantes.dominio.entity.Comprobante;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class EmitirComprobantesMapper {

    public Comprobante toComprobante(String numero, String tipo, String cliente, Double monto) {
        Comprobante c = new Comprobante();
        c.setNumero(numero);
        c.setTipo(tipo);
        c.setCliente(cliente);
        c.setMonto(monto);
        c.setFecha(LocalDate.now());
        c.setEstado("Emitido");
        return c;
    }
}