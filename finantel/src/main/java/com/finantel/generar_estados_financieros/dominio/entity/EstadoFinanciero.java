package com.finantel.generar_estados_financieros.dominio.entity;

public class EstadoFinanciero {

    private String tipo;
    private Double totalDebe;
    private Double totalHaber;
    private Double resultado;

    public EstadoFinanciero(String tipo, Double totalDebe, Double totalHaber) {
        this.tipo = tipo;
        this.totalDebe = totalDebe;
        this.totalHaber = totalHaber;
        this.resultado = totalHaber - totalDebe;
    }

    public String getTipo() { return tipo; }
    public Double getTotalDebe() { return totalDebe; }
    public Double getTotalHaber() { return totalHaber; }
    public Double getResultado() { return resultado; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setTotalDebe(Double d) { this.totalDebe = d; }
    public void setTotalHaber(Double h) { this.totalHaber = h; }
    public void setResultado(Double r) { this.resultado = r; }
}