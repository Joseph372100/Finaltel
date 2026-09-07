package com.finantel.registrar_usuario.dominio.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String email;
    private String rol;
    private String estado;
    private Integer intentos;
    private String dni;
    private String telefono;
    private String direccion;
    private String cargo;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_ultimo_acceso")
    private LocalDateTime fechaUltimoAcceso;

    // Getters
    public Integer getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public String getPassword() { return password; }
    public String getRol() { return rol; }
    public String getEstado() { return estado; }
    public Integer getIntentos() { return intentos; }
    public String getDni() { return dni; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public String getCargo() { return cargo; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public LocalDateTime getFechaUltimoAcceso() { return fechaUltimoAcceso; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRol(String rol) { this.rol = rol; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setIntentos(Integer intentos) { this.intentos = intentos; }
    public void setDni(String dni) { this.dni = dni; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public void setFechaRegistro(LocalDateTime f) { this.fechaRegistro = f; }
    public void setFechaUltimoAcceso(LocalDateTime f) { this.fechaUltimoAcceso = f; }
   
}