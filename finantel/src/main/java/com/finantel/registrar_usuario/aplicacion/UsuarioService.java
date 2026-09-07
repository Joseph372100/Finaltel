package com.finantel.registrar_usuario.aplicacion;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import com.finantel.registrar_usuario.dominio.entity.Usuario;
import com.finantel.registrar_usuario.dominio.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	private final UsuarioRepository repo;
	private final PasswordEncoder passwordEncoder;
	private final AuditoriaService auditoriaService;

	public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder, AuditoriaService auditoriaService) {
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
		this.auditoriaService = auditoriaService;
	}

	public List<Usuario> listar() {
		return repo.findAll();
	}

	public void crear(Usuario u) {
		List<String> errores = new ArrayList<>();

		// Validar rol
		List<String> rolesValidos = Arrays.asList("Administrador", "Contador_General", "Auditor",
				"Personal_Autorizado");
		if (repo.findByEmail(u.getEmail()).isPresent())
		    errores.add("El email ya está registrado");
		if (u.getRol() == null || !rolesValidos.contains(u.getRol()))
			errores.add(
					"Rol inválido. Los roles válidos son: Administrador, Contador_General, Auditor, Personal_Autorizado");
	if (u.getPassword() == null || u.getPassword().length() <= 6)
			errores.add("La contraseña debe tener minimo 6 caracteres");
		if (u.getDni() != null && !u.getDni().isBlank() && !u.getDni().matches("\\d{8}"))
			errores.add("El DNI debe tener exactamente 8 numeros");
		if (u.getTelefono() != null && !u.getTelefono().isBlank() && !u.getTelefono().matches("9\\d{8}"))
			errores.add("El teléfono debe tener 9 dígitos y empezar en 9");
		if (!errores.isEmpty())
			throw new RuntimeException(String.join(", ", errores));

		u.setPassword(passwordEncoder.encode(u.getPassword()));
		u.setEstado("Activo");
		u.setIntentos(0);
		repo.save(u);
		auditoriaService.registrar(u.getEmail(), "Creación", "Usuarios", null, "Usuario " + u.getNombre() + " creado");
	}

	public Usuario buscarPorId(Integer id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	public void actualizarRol(Integer id, String nuevoRol) {
		Usuario u = buscarPorId(id);
		String anterior = u.getRol();
		u.setRol(nuevoRol);
		repo.save(u);
		auditoriaService.registrar(u.getEmail(), "Cambio de rol", "Usuarios", anterior, nuevoRol);
	}

	public void cambiarEstado(Integer id, String estado) {
		Usuario u = buscarPorId(id);
		String anterior = u.getEstado();
		u.setEstado(estado);
		repo.save(u);
		auditoriaService.registrar(u.getEmail(), "Cambio de estado", "Usuarios", anterior, estado);
	}

	public void eliminar(Integer id) {
		Usuario u = buscarPorId(id);
		repo.deleteById(id);
		auditoriaService.registrar(u.getEmail(), "Eliminación", "Usuarios", "Activo", "Eliminado");
	}

	public void actualizar(Integer id, String nombre, String rol, String estado) {
		Usuario u = buscarPorId(id);
		String anterior = u.getNombre() + " - " + u.getRol() + " - " + u.getEstado();
		u.setNombre(nombre);
		u.setRol(rol);
		u.setEstado(estado);
		repo.save(u);
		auditoriaService.registrar(u.getEmail(), "Actualización", "Usuarios", anterior,
				nombre + " - " + rol + " - " + estado);
	}

	public void cambiarPassword(Integer id, String passwordActual, String passwordNueva) {
		Usuario u = buscarPorId(id);

		if (!passwordEncoder.matches(passwordActual, u.getPassword())) {
			throw new RuntimeException("La contraseña actual es incorrecta");
		}

		if (passwordNueva == null || passwordNueva.length() < 8) {
			throw new RuntimeException("La nueva contraseña debe tener mínimo 8 caracteres");
		}

		String anterior = "Contraseña cambiada";
		u.setPassword(passwordEncoder.encode(passwordNueva));
		repo.save(u);

		auditoriaService.registrar(u.getEmail(), "Cambio de contraseña", "Usuarios", anterior,
				"Nueva contraseña establecida");
	}

}