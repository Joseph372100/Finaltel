package com.finantel.inactivar_asiento.dominio.entity;

public class AsientoInactivo {

    private Integer id;
    private String motivo;
    private String fechaInactivacion;

    public AsientoInactivo(Integer id, String motivo, String fechaInactivacion) {
        this.id = id;
        this.motivo = motivo;
        this.fechaInactivacion = fechaInactivacion;
    }

    public Integer getId() { return id; }
    public String getMotivo() { return motivo; }
    public String getFechaInactivacion() { return fechaInactivacion; }
    public void setId(Integer id) { this.id = id; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public void setFechaInactivacion(String f) { this.fechaInactivacion = f; }
}