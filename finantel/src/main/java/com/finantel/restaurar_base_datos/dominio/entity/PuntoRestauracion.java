package com.finantel.restaurar_base_datos.dominio.entity;

public class PuntoRestauracion {

    private Integer id;
    private String fecha;
    private String tipo;
    private String estado;

    public PuntoRestauracion(Integer id, String fecha, String tipo, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Integer getId() { return id; }
    public String getFecha() { return fecha; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
    public void setId(Integer id) { this.id = id; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setEstado(String estado) { this.estado = estado; }
}