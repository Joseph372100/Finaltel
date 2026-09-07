package com.finantel.tipo_cambio.dominio.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TipoCambio")
public class TipoCambio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha;
    private Double compra;
    private Double venta;
    private String fuente;
    private String estado;
    private String moneda;

    public Integer getId() { return id; }
    public LocalDate getFecha() { return fecha; }
    public Double getCompra() { return compra; }
    public Double getVenta() { return venta; }
    public String getFuente() { return fuente; }
    public String getEstado() { return estado; }
    public String getMoneda() { return moneda; }

    public void setId(Integer id) { this.id = id; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public void setCompra(Double compra) { this.compra = compra; }
    public void setVenta(Double venta) { this.venta = venta; }
    public void setFuente(String fuente) { this.fuente = fuente; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setMoneda(String moneda) { this.moneda = moneda; }
}