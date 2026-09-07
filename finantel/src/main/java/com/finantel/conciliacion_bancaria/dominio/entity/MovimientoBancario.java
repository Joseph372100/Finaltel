package com.finantel.conciliacion_bancaria.dominio.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MovimientosBancarios")
public class MovimientoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha;
    private String descripcion;
    private Double monto;
    private String tipo;
    private String estado;

    public Integer getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public String getDescripcion() { return descripcion; }
    public Double getMonto() { return monto; }
    public String getTipo() { return tipo; }
    public String getEstado() { return estado; }

    public void setId(Integer id) { this.id = id; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setDescripcion(String d) { this.descripcion = d; }
    public void setMonto(Double monto) { this.monto = monto; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setEstado(String estado) { this.estado = estado; }
}