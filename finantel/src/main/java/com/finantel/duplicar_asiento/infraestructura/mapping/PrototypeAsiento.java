package com.finantel.duplicar_asiento.infraestructura.mapping;

/**
 * PATRÓN DE DISEÑO: Prototype
 * Clona un asiento contable existente de la BD para crear uno nuevo.
 */
public class PrototypeAsiento implements Cloneable {

    private String numeroCorrelativo;
    private String tipo;
    private String descripcion;
    private Double debe;
    private Double haber;
    private String cuentaContable;
    private String usuario;
    private String periodo;

    public PrototypeAsiento(String numeroCorrelativo, String tipo, String descripcion,
                             Double debe, Double haber, String cuentaContable,
                             String usuario, String periodo) {
        this.numeroCorrelativo = numeroCorrelativo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.debe = debe;
        this.haber = haber;
        this.cuentaContable = cuentaContable;
        this.usuario = usuario;
        this.periodo = periodo;
    }

    public PrototypeAsiento clonar(String nuevoCorrelativo) {
        try {
            PrototypeAsiento clon = (PrototypeAsiento) this.clone();
            clon.numeroCorrelativo = nuevoCorrelativo;
            clon.descripcion = "COPIA - " + this.descripcion;
            return clon;
        } 
        	catch (CloneNotSupportedException e) {
            throw new RuntimeException("No se pudo clonar el asiento", e);
        }
    }

    public String getPatron() {
        return "Patrón Prototype — PrototypeAsiento";
    }

    @Override
    public String toString() {
        return getPatron() +
            " | correlativo='" + numeroCorrelativo + "'" +
            ", tipo='" + tipo + "'" +
            ", descripcion='" + descripcion + "'" +
            ", debe=" + debe +
            ", haber=" + haber +
            ", cuenta='" + cuentaContable + "'" +
            ", usuario='" + usuario + "'" +
            ", periodo='" + periodo + "'";
    }

    public String getNumeroCorrelativo() { return numeroCorrelativo; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public Double getDebe() { return debe; }
    public Double getHaber() { return haber; }
    public String getCuentaContable() { return cuentaContable; }
    public String getUsuario() { return usuario; }
    public String getPeriodo() { return periodo; }
}