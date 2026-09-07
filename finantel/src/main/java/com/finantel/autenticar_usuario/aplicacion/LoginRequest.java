package com.finantel.autenticar_usuario.aplicacion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginRequest {

    @NotBlank(message = "El email es obligatorio")
    @Pattern(
        regexp = "^[a-zA-Z0-9._%+-]+@finantel\\.pe$",
        message = "Ingrese un correo válido de FINANTEL (@finantel.pe)"
    )
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener mínimo 6 caracteres")
    private String password;

    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}