package com.finantel.registrar_accion.dominio.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AuditoriaAcciones")
public class AuditoriaAccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime fecha;
    private String usuario;
    private String accion;
    private String objeto;

    @Column(name = "valor_anterior")
    private String valorAnterior;

    @Column(name = "valor_nuevo")
    private String valorNuevo;

    // Getters y Setters
    public Integer getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public String getUsuario() { return usuario; }
    public String getAccion() { return accion; }
    public String getObjeto() { return objeto; }
    public String getValorAnterior() { return valorAnterior; }
    public String getValorNuevo() { return valorNuevo; }

    public void setId(Integer id) { this.id = id; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public void setAccion(String accion) { this.accion = accion; }
    public void setObjeto(String objeto) { this.objeto = objeto; }
    public void setValorAnterior(String valorAnterior) { this.valorAnterior = valorAnterior; }
    public void setValorNuevo(String valorNuevo) { this.valorNuevo = valorNuevo; }
}