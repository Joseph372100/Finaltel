package com.finantel.autenticar_usuario.infraestructura.persistence;

import com.finantel.registrar_usuario.dominio.entity.Usuario;
import com.finantel.registrar_usuario.dominio.repository.UsuarioRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Optional;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private final UsuarioRepository repo;

    public LoginFailureHandler(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                         HttpServletResponse response,
                                         AuthenticationException exception) throws IOException {
        String email = request.getParameter("username");
        Optional<Usuario> opt = repo.findByEmail(email);
        if (opt.isPresent()) {
            Usuario u = opt.get();
            int intentos = u.getIntentos() == null ? 0 : u.getIntentos();
            intentos++;
            u.setIntentos(intentos);
            if (intentos >= 3) {
                u.setEstado("Bloqueado");
            }
            repo.save(u);
        }
        response.sendRedirect("/login?error=true");
    }
}