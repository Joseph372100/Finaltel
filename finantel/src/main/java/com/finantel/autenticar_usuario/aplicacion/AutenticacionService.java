package com.finantel.autenticar_usuario.aplicacion;

import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

	public boolean validarCredenciales(String email, String password) {
		return email != null && !email.isEmpty() && password != null && !password.isEmpty();
	}

	public boolean estaActivo(String estado) {
		return "Activo".equalsIgnoreCase(estado);
	}
}