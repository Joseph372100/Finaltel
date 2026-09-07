package com.finantel.emitir_comprobantes.aplicacion;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import com.finantel.emitir_comprobantes.dominio.entity.Comprobante;
import com.finantel.emitir_comprobantes.dominio.repository.EmitirComprobantesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmitirComprobantesService {

    private final EmitirComprobantesRepository repo;
    private final AuditoriaService auditoriaService;

    public EmitirComprobantesService(EmitirComprobantesRepository repo,
                                      AuditoriaService auditoriaService) {
        this.repo = repo;
        this.auditoriaService = auditoriaService;
    }

    public List<Comprobante> listar() {
        return repo.findAll();
    }

    public void emitir(Comprobante comprobante, String usuario) {
        List<String> errores = new java.util.ArrayList<>();

        // Validar número
        if (comprobante.getNumero() == null || comprobante.getNumero().isBlank())
            errores.add("El número de comprobante es obligatorio. Ejemplo: F001-001");

        // Validar tipo
        List<String> tiposValidos = java.util.Arrays.asList("Factura", "Boleta", "Recibo de Pago", "Nota de Débito", "Nota de Crédito");
        if (comprobante.getTipo() == null || !tiposValidos.contains(comprobante.getTipo()))
            errores.add("Tipo inválido. Válidos: Factura, Boleta, Recibo de Pago, Nota de Débito, Nota de Crédito");

        // Validar cliente
        if (comprobante.getCliente() == null || comprobante.getCliente().isBlank())
            errores.add("El cliente es obligatorio. Ejemplo: Empresa ABC SAC");

        // Validar monto
        if (comprobante.getMonto() == null || comprobante.getMonto() <= 0)
            errores.add("El monto debe ser mayor a 0. Ejemplo: 1500.00");

        if (!errores.isEmpty())
            throw new RuntimeException(String.join(" | ", errores));

        comprobante.setEstado("Emitido");
        repo.save(comprobante);
        auditoriaService.registrar(
            usuario, "Emisión", "Comprobantes",
            null, "Comprobante " + comprobante.getNumero() + " emitido"
        );
    }
}
