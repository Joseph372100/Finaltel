package com.finantel.gestionar_periodos.dominio.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PeriodosContables")
public class PeriodoContable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String periodo;
    private String estado;
    
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;
    
    @Column(name = "fecha_cierre")
    private LocalDate fechaCierre;
    
    @Column(name = "cerrado_por")
    private String cerradoPor;

    public Integer getId() { return id; }
    public String getPeriodo() { return periodo; }
    public void setPeriodo(String p) { this.periodo = p; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate f) { this.fechaInicio = f; }
    public LocalDate getFechaCierre() { return fechaCierre; }
    public void setFechaCierre(LocalDate f) { this.fechaCierre = f; }
    public String getEstado() { return estado; }
    public void setEstado(String e) { this.estado = e; }
    public String getCerradoPor() { return cerradoPor; }
    public void setCerradoPor(String c) { this.cerradoPor = c; }
}