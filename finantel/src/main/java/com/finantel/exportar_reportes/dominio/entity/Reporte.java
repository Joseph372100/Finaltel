package com.finantel.exportar_reportes.dominio.entity;

public class Reporte {

    private String tipo;
    private String formato;
    private Integer totalRegistros;

    public Reporte(String tipo, String formato, Integer totalRegistros) {
        this.tipo = tipo;
        this.formato = formato;
        this.totalRegistros = totalRegistros;
    }

    public String getTipo() { return tipo; }
    public String getFormato() { return formato; }
    public Integer getTotalRegistros() { return totalRegistros; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setFormato(String f) { this.formato = f; }
    public void setTotalRegistros(Integer t) { this.totalRegistros = t; }
}