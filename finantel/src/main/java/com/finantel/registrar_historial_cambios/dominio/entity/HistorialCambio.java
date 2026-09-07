package com.finantel.registrar_historial_cambios.dominio.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AuditoriaAcciones")
public class HistorialCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime fecha;
    private String usuario;

    @Column(name = "accion")
    private String campo;

    @Column(name = "objeto")
    private String objeto;

    @Column(name = "valor_anterior")
    private String valorAnterior;

    @Column(name = "valor_nuevo")
    private String valorNuevo;

    public Integer getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public String getUsuario() { return usuario; }
    public String getCampo() { return campo; }
    public String getObjeto() { return objeto; }
    public String getValorAnterior() { return valorAnterior; }
    public String getValorNuevo() { return valorNuevo; }

    public void setId(Integer id) { this.id = id; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setCampo(String campo) { this.campo = campo; }
    public void setObjeto(String objeto) { this.objeto = objeto; }
    public void setValorAnterior(String v) { this.valorAnterior = v; }
    public void setValorNuevo(String v) { this.valorNuevo = v; }
}