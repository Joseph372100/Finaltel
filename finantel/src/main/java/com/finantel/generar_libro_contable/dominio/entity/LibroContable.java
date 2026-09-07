package com.finantel.generar_libro_contable.dominio.entity;

public class LibroContable {

    private String periodo;
    private Integer totalAsientos;
    private Double totalDebe;
    private Double totalHaber;

    public LibroContable(String periodo, Integer totalAsientos, Double totalDebe, Double totalHaber) {
        this.periodo = periodo;
        this.totalAsientos = totalAsientos;
        this.totalDebe = totalDebe;
        this.totalHaber = totalHaber;
    }

    public String getPeriodo() { return periodo; }
    public Integer getTotalAsientos() { return totalAsientos; }
    public Double getTotalDebe() { return totalDebe; }
    public Double getTotalHaber() { return totalHaber; }
    public void setPeriodo(String p) { this.periodo = p; }
    public void setTotalAsientos(Integer t) { this.totalAsientos = t; }
    public void setTotalDebe(Double d) { this.totalDebe = d; }
    public void setTotalHaber(Double h) { this.totalHaber = h; }
}