package com.finantel.autenticar_usuario.presentacion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.finantel.registrar_usuario.dominio.repository.UsuarioRepository;
import java.security.Principal;
@Controller
public class DashboardController {
    private final UsuarioRepository repo;
    public DashboardController(UsuarioRepository repo) {
        this.repo = repo;
    }
    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        String email = principal.getName();
        repo.findByEmail(email).ifPresent(u -> {
            model.addAttribute("userName", u.getNombre());
            model.addAttribute("userRol", u.getRol());
            model.addAttribute("userInitials", 
                java.util.Arrays.stream(u.getNombre().split(" "))
                    .limit(2)
                    .map(p -> String.valueOf(p.charAt(0)).toUpperCase())
                    .reduce("", String::concat)
            );
        });
        return "Finantel";
    }
}