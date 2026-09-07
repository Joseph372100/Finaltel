package com.finantel.duplicar_asiento.dominio.entity;

public class AsientoDuplicado {

    private Integer idOriginal;
    private Integer idCopia;

    public AsientoDuplicado(Integer idOriginal, Integer idCopia) {
        this.idOriginal = idOriginal;
        this.idCopia = idCopia;
    }

    public Integer getIdOriginal() { return idOriginal; }
    public Integer getIdCopia() { return idCopia; }
    public void setIdOriginal(Integer id) { this.idOriginal = id; }
    public void setIdCopia(Integer id) { this.idCopia = id; }
}