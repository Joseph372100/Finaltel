package com.finantel.registrar_asiento_contable.infraestructura.mapping;

public class BuilderAsiento {

    private String numeroCorrelativo;
    private String tipo;
    private String descripcion;
    private Double debe;
    private Double haber;
    private String cuentaContable;
    private String centroCosto;
    private String moneda = "PEN";
    private Double tipoCambio = 1.0;
    private String usuario;

    private BuilderAsiento() {}

    public String getNumeroCorrelativo() { return numeroCorrelativo; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public Double getDebe() { return debe; }
    public Double getHaber() { return haber; }
    public String getCuentaContable() { return cuentaContable; }
    public String getCentroCosto() { return centroCosto; }
    public String getMoneda() { return moneda; }
    public Double getTipoCambio() { return tipoCambio; }
    public String getUsuario() { return usuario; }

    public String getPatron() {
        return "Patrón Builder — BuilderAsiento";
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
            ", centroCosto='" + centroCosto + "'" +
            ", moneda='" + moneda + "'" +
            ", tipoCambio=" + tipoCambio +
            ", usuario='" + usuario + "'";
    }

        public static class Builder {

        private String numeroCorrelativo;
        private String tipo;
        private String descripcion;
        private Double debe;
        private Double haber;
        private String cuentaContable;
        private String centroCosto;
        private String moneda = "PEN";
        private Double tipoCambio = 1.0;
        private String usuario;

        public Builder numeroCorrelativo(String numeroCorrelativo) {
            this.numeroCorrelativo = numeroCorrelativo;
            return this;
        }
        public Builder tipo(String tipo) {
            this.tipo = tipo;
            return this;
        }
        
        public Builder debe(Double debe) {
            this.debe = debe;
            return this;
        }
        public Builder haber(Double haber) {
            this.haber = haber;
            return this;
        }
        public Builder cuentaContable(String cuentaContable) {
            this.cuentaContable = cuentaContable;
            return this;
        }
        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }
        public Builder centroCosto(String centroCosto) {
            this.centroCosto = centroCosto;
            return this;
        }
        public Builder moneda(String moneda) {
            this.moneda = moneda;
            return this;
        }
        public Builder tipoCambio(Double tipoCambio) {
            this.tipoCambio = tipoCambio;
            return this;
        }
        public Builder usuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public BuilderAsiento build() {
            if (numeroCorrelativo == null || numeroCorrelativo.isBlank())
                throw new IllegalStateException("El numero correlativo es obligatorio.");
            if (tipo == null || tipo.isBlank())
                throw new IllegalStateException("El tipo es obligatorio");
            if (debe == null)
                throw new IllegalStateException("El debe es obligatorio");
            if (haber == null)
                throw new IllegalStateException("El haber es obligatorio");
            if (cuentaContable == null || cuentaContable.isBlank())
                throw new IllegalStateException("La cuenta contable es obligatoria");
            if (usuario == null || usuario.isBlank())
                throw new IllegalStateException("El usuario es obligatorio");
            //opcionalesdescripcioncentroCostomonedatipoCambio
            BuilderAsiento asiento = new BuilderAsiento();
            asiento.numeroCorrelativo = this.numeroCorrelativo;
            asiento.tipo = this.tipo;
            asiento.descripcion = this.descripcion;
            asiento.debe = this.debe;
            asiento.haber = this.haber;
            asiento.cuentaContable = this.cuentaContable;
            asiento.centroCosto = this.centroCosto;
            asiento.moneda = this.moneda;
            asiento.tipoCambio = this.tipoCambio;
            asiento.usuario = this.usuario;
            return asiento;
        }
    }
}