package com.finantel.autenticar_usuario.infraestructura.persistence;

import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import com.finantel.registrar_usuario.dominio.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final UsuarioRepository repo;
    private final AuditoriaService auditoriaService;

    public LoginSuccessHandler(UsuarioRepository repo, AuditoriaService auditoriaService) {
        this.repo = repo;
        this.auditoriaService = auditoriaService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Authentication authentication) throws IOException {
        String email = authentication.getName();
        System.out.println("AUTHORITIES LOGIN: " + authentication.getAuthorities());
        repo.findByEmail(email).ifPresent(u -> {
            u.setIntentos(0);
            u.setFechaUltimoAcceso(java.time.LocalDateTime.now());
            repo.save(u);
        });
        auditoriaService.registrar(email, "Login exitoso", "Sesión", "—", "Acceso al sistema");
        response.sendRedirect("/dashboard");
    }
}