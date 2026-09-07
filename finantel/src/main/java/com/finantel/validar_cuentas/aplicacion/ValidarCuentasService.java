package com.finantel.validar_cuentas.aplicacion;

import com.finantel.validar_cuentas.dominio.entity.CuentaContable;
import com.finantel.validar_cuentas.dominio.repository.ValidarCuentasRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValidarCuentasService {

    private final ValidarCuentasRepository repo;

    public ValidarCuentasService(ValidarCuentasRepository repo) {
        this.repo = repo;
    }

    public String validarCuenta(String codigo) {
        return repo.findByCodigo(codigo)
            .map(c -> "Activo".equalsIgnoreCase(c.getEstado())
                ? "Cuenta válida y activa"
                : "Cuenta inactiva — no permitida")
            .orElse("Cuenta no encontrada");
    }

    public List<CuentaContable> listarCuentasActivas() {
        return repo.findByEstado("Activo");
    }
    public List<CuentaContable> listar() {
        return repo.findAll();
    }

    public void crear(CuentaContable c) {
        List<String> errores = new java.util.ArrayList<>();
        
        // Validar código — solo números enteros
        if (c.getCodigo() == null || !c.getCodigo().matches("\\d+"))
            errores.add("El código debe contener solo números enteros. Ejemplo: 1023");
        
        // Validar clasificación
        List<String> clasifValidas = java.util.Arrays.asList(
            "Activo Corriente", "Activo No Corriente", "Pasivo Corriente", 
            "Pasivo No Corriente", "Patrimonio", "Ingresos", "Gastos");
        if (c.getClasificacion() == null || !clasifValidas.contains(c.getClasificacion()))
            errores.add("Clasificación inválida. Válidas: " + String.join(", ", clasifValidas));
        
        // Validar tipo
        List<String> tiposValidos = java.util.Arrays.asList("Débito", "Crédito");
        if (c.getTipo() == null || !tiposValidos.contains(c.getTipo()))
            errores.add("Tipo inválido. Válidos: Débito, Crédito");
        
        // Validar estado
        List<String> estadosValidos = java.util.Arrays.asList("Activa", "Inactiva");
        if (c.getEstado() == null || !estadosValidos.contains(c.getEstado()))
            errores.add("Estado inválido. Válidos: Activa, Inactiva");
        
        if (!errores.isEmpty())
            throw new RuntimeException(String.join(" | ", errores));
        
        repo.save(c);
    }
}