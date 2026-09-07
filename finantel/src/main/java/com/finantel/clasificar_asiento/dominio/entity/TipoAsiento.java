package com.finantel.clasificar_asiento.dominio.entity;

public class TipoAsiento {

    private String nombre;
    private String descripcion;

    public TipoAsiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}