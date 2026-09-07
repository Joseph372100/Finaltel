package com.finantel.validar_cuentas.dominio.repository;

import com.finantel.validar_cuentas.dominio.entity.CuentaContable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ValidarCuentasRepository extends JpaRepository<CuentaContable, String> {
    Optional<CuentaContable> findByCodigo(String codigo);
    List<CuentaContable> findByEstado(String estado);
}