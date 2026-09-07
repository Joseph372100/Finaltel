package com.finantel.validar_cuentas.infraestructura.mapping;

import com.finantel.validar_cuentas.dominio.entity.CuentaContable;
import org.springframework.stereotype.Component;

@Component
public class ValidarCuentasMapper {

    public String toResumen(CuentaContable c) {
        return c.getCodigo() + " - " + c.getDescripcion() + " [" + c.getEstado() + "]";
    }
}