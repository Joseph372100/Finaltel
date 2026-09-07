package com.finantel.autenticar_usuario.dominio.entity;

public class Credencial {

    private String email;
    private String password;

    public Credencial(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}