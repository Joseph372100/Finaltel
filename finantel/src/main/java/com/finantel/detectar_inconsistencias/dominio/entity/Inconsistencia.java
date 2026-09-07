package com.finantel.detectar_inconsistencias.dominio.entity;

public class Inconsistencia {

    private Integer idAsiento;
    private String tipoError;
    private String descripcion;

    public Inconsistencia(Integer idAsiento, String tipoError, String descripcion) {
        this.idAsiento = idAsiento;
        this.tipoError = tipoError;
        this.descripcion = descripcion;
    }

    public Integer getIdAsiento() { return idAsiento; }
    public String getTipoError() { return tipoError; }
    public String getDescripcion() { return descripcion; }
    public void setIdAsiento(Integer id) { this.idAsiento = id; }
    public void setTipoError(String t) { this.tipoError = t; }
    public void setDescripcion(String d) { this.descripcion = d; }
}