package com.finantel.emitir_comprobantes.dominio.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Comprobantes")
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;
    private LocalDate fecha;
    private String tipo;
    private String cliente;
    private Double monto;
    private String estado;

    public Integer getId() { return id; }
    public String getNumero() { return numero; }
    public LocalDate getFecha() { return fecha; }
    public String getTipo() { return tipo; }
    public String getCliente() { return cliente; }
    public Double getMonto() { return monto; }
    public String getEstado() { return estado; }

    public void setId(Integer id) { this.id = id; }
    public void setNumero(String numero) { this.numero = numero; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setMonto(Double monto) { this.monto = monto; }
    public void setEstado(String estado) { this.estado = estado; }
}