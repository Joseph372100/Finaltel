package com.finantel.validar_cuentas.dominio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CuentasContables")
public class CuentaContable {

    @Id
    private String codigo;
    private String descripcion;
    private String clasificacion;
    private String tipo;
    private String estado;

    @Column(name = "ops_autorizadas")
    private String opsAutorizadas;

    public String getCodigo() { return codigo; }
    public String getDescripcion() { return descripcion; }
    public String getClasificacion() { return clasificacion; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
    public String getOpsAutorizadas() { return opsAutorizadas; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setDescripcion(String d) { this.descripcion = d; }
    public void setClasificacion(String c) { this.clasificacion = c; }
    public void setTipo(String t) { this.tipo = t; }
    public void setEstado(String e) { this.estado = e; }
    public void setOpsAutorizadas(String o) { this.opsAutorizadas = o; }
}