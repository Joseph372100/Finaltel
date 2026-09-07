package com.finantel.registrar_asiento_contable.aplicacion;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import java.util.ArrayList;
import java.util.Arrays;
import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import com.finantel.registrar_asiento_contable.dominio.repository.AsientoContableRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsientoContableService {
	
    private final AsientoContableRepository repo;
    private final AuditoriaService auditoriaService;

    public AsientoContableService(AsientoContableRepository repo,
                                   AuditoriaService auditoriaService) {
        this.repo = repo;
        this.auditoriaService = auditoriaService;
    }

    public List<AsientoContable> listar() {
        return repo.findAll();
    }

    public AsientoContable buscarPorId(Integer id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
    }

    public void actualizar(Integer id, AsientoContable datos) {
        AsientoContable a = buscarPorId(id);
        String anterior = a.getTipo() + ": " + a.getDescripcion();
        if (datos.getDescripcion() != null) a.setDescripcion(datos.getDescripcion());
        if (datos.getTipo() != null) a.setTipo(datos.getTipo());
        if (datos.getEstado() != null) a.setEstado(datos.getEstado());
        if (datos.getDebe() != null) a.setDebe(datos.getDebe());
        if (datos.getHaber() != null) a.setHaber(datos.getHaber());
        repo.save(a);
        auditoriaService.registrar(
            a.getUsuario(), "Edición", "AsientosContables",
            anterior, datos.getTipo() + ": " + datos.getDescripcion()
        );
    }
    public void anular(Integer id) {
        AsientoContable a = buscarPorId(id);
        a.setEstado("Anulado");
        repo.save(a);
        auditoriaService.registrar(
            a.getUsuario(), "Anulación", "AsientosContables",
            "Activo", "Anulado"
        );
    }
    public void duplicar(Integer id, String usuario) {
        AsientoContable original = buscarPorId(id);
        AsientoContable copia = new AsientoContable();
        copia.setTipo(original.getTipo());
        copia.setDescripcion("COPIA - " + original.getDescripcion());
        copia.setDebe(original.getDebe());
        copia.setHaber(original.getHaber());
        copia.setEstado("Activo");
        copia.setUsuario(usuario);
        copia.setCuentaContable(original.getCuentaContable());
        copia.setCentroCosto(original.getCentroCosto());
        copia.setMoneda(original.getMoneda());
        copia.setTipoCambio(original.getTipoCambio());
        repo.save(copia);
        auditoriaService.registrar(
            usuario, "Duplicación", "AsientosContables",
            String.valueOf(id), "COPIA - " + original.getDescripcion()
        );
    }
    public void crear(AsientoContable a) {
        List<String> errores = new ArrayList<>();
        
        // Validar tipo
        List<String> tiposValidos = Arrays.asList("Apertura", "Operación ordinaria", "Ajuste", "Cierre", "Reversión");
        if (a.getTipo() == null || !tiposValidos.contains(a.getTipo()))
            errores.add("Tipo inválido. Ejemplo: 'Operación ordinaria'. Válidos: " + String.join(", ", tiposValidos));
        
        // Validar descripción
        if (a.getDescripcion() == null || a.getDescripcion().isBlank())
            errores.add("Descripción es obligatoria. Ejemplo: 'Cobro cuota crédito'");
        
        // Validar debe y haber
        if (a.getDebe() == null || a.getDebe() <= 0)
            errores.add("El campo 'debe' debe ser mayor a 0. Ejemplo: 5000.00");
        if (a.getHaber() == null || a.getHaber() <= 0)
            errores.add("El campo 'haber' debe ser mayor a 0. Ejemplo: 5000.00");
        
        // Validar cuadre
        if (a.getDebe() != null && a.getHaber() != null && Math.abs(a.getDebe() - a.getHaber()) > 0.01)
            errores.add("El asiento no cuadra. Debe y Haber deben ser iguales. Debe: " + a.getDebe() + " ≠ Haber: " + a.getHaber());
        
        // Validar cuenta contable
        if (a.getCuentaContable() == null || a.getCuentaContable().isBlank())
        errores.add("La cuenta contable es obligatoria. Ejemplo: '1011'");
        
        //validar moneda
        List<String> monedasValidas = Arrays.asList("PEN", "USD");
        if (a.getMoneda() == null || !monedasValidas.contains(a.getMoneda()))
            errores.add("La moneda es obligatoria y debe ser 'PEN' o 'USD'. Recibido: '" + a.getMoneda() + "'");

        if (!errores.isEmpty())
        throw new RuntimeException(String.join(" | ", errores));

        a. setEstado("Activo");
        repo. save(a);
    }
}