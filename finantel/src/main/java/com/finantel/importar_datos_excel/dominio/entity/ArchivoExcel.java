package com.finantel.importar_datos_excel.dominio.entity;

public class ArchivoExcel {

    private String nombre;
    private Long tamanio;
    private String estado;

    public ArchivoExcel(String nombre, Long tamanio, String estado) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.estado = estado;
    }

    public String getNombre() { return nombre; }
    public Long getTamanio() { return tamanio; }
    public String getEstado() { return estado; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTamanio(Long tamanio) { this.tamanio = tamanio; }
    public void setEstado(String estado) { this.estado = estado; }
}