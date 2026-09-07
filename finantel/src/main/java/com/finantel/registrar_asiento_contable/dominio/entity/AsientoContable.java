package com.finantel.registrar_asiento_contable.dominio.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AsientosContables")
public class AsientoContable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private Double debe;
    private Double haber;
    private String estado;
    private String tipo;
    private String usuario;

    @Column(name = "numero_correlativo")
    private String numeroCorrelativo;

    @Column(name = "cuenta_contable")
    private String cuentaContable;

    @Column(name = "centro_costo")
    private String centroCosto;

    private String moneda;

    @Column(name = "tipo_cambio")
    private Double tipoCambio;

    private String glosa;

    @Column(name = "referencia_documento")
    private String referenciaDocumento;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    // Getters
    public Integer getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public Double getDebe() { return debe; }
    public Double getHaber() { return haber; }
    public String getEstado() { return estado; }
    public String getTipo() { return tipo; }
    public String getUsuario() { return usuario; }
    public String getNumeroCorrelativo() { return numeroCorrelativo; }
    public String getCuentaContable() { return cuentaContable; }
    public String getCentroCosto() { return centroCosto; }
    public String getMoneda() { return moneda; }
    public Double getTipoCambio() { return tipoCambio; }
    public String getGlosa() { return glosa; }
    public String getReferenciaDocumento() { return referenciaDocumento; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public LocalDateTime getFechaModificacion() { return fechaModificacion; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setDescripcion(String d) { this.descripcion = d; }
    public void setDebe(Double d) { this.debe = d; }
    public void setHaber(Double h) { this.haber = h; }
    public void setEstado(String e) { this.estado = e; }
    public void setTipo(String t) { this.tipo = t; }
    public void setUsuario(String u) { this.usuario = u; }
    public void setNumeroCorrelativo(String n) { this.numeroCorrelativo = n; }
    public void setCuentaContable(String c) { this.cuentaContable = c; }
    public void setCentroCosto(String c) { this.centroCosto = c; }
    public void setMoneda(String m) { this.moneda = m; }
    public void setTipoCambio(Double t) { this.tipoCambio = t; }
    public void setGlosa(String g) { this.glosa = g; }
    public void setReferenciaDocumento(String r) { this.referenciaDocumento = r; }
    public void setFechaRegistro(LocalDateTime f) { this.fechaRegistro = f; }
    public void setFechaModificacion(LocalDateTime f) { this.fechaModificacion = f; }
}