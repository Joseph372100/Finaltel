package com.finantel.realizar_copia_seguridad.dominio.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RespaldosBD")
public class CopiaSeguridadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime fecha;
    private String usuario;
    private String tipo;
    private String estado;
    private String tamanio;

    public Integer getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public String getUsuario() { return usuario; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }
    public String getTamanio() { return tamanio; }

    public void setId(Integer id) { this.id = id; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setTamanio(String tamanio) { this.tamanio = tamanio; }
}