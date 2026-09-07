package com.finantel.buscar_asiento.dominio.entity;

public class FiltroAsiento {

    private String tipo;
    private String usuario;
    private String estado;

    public FiltroAsiento(String tipo, String usuario, String estado) {
        this.tipo = tipo;
        this.usuario = usuario;
        this.estado = estado;
    }

    public String getTipo() { return tipo; }
    public String getUsuario() { return usuario; }
    public String getEstado() { return estado; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setEstado(String estado) { this.estado = estado; }
}