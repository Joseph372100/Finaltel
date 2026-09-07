package com.finantel.visualizar_reportes_graficos.dominio.entity;

public class ReporteGrafico {

    private String tipo;
    private Double valor;
    private String etiqueta;

    public ReporteGrafico(String tipo, Double valor, String etiqueta) {
        this.tipo = tipo;
        this.valor = valor;
        this.etiqueta = etiqueta;
    }

    public String getTipo() { return tipo; }
    public Double getValor() { return valor; }
    public String getEtiqueta() { return etiqueta; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setValor(Double valor) { this.valor = valor; }
    public void setEtiqueta(String etiqueta) { this.etiqueta = etiqueta; }
}