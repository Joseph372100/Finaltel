package com.finantel.autenticar_usuario.infraestructura.persistence;

import com.finantel.autenticar_usuario.infraestructura.jwt.JwtFilter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@EnableMethodSecurity
@Configuration
public class WebSecurityConfig {

	private final LoginFailureHandler loginFailureHandler;
	private final LoginSuccessHandler loginSuccessHandler;
	private final JwtFilter jwtFilter;

	public WebSecurityConfig(LoginFailureHandler loginFailureHandler, LoginSuccessHandler loginSuccessHandler,
			JwtFilter jwtFilter) {
		this.loginFailureHandler = loginFailureHandler;
		this.loginSuccessHandler = loginSuccessHandler;
		this.jwtFilter = jwtFilter;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Order(1)
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/auth/**", "/usuarios/**", "/asientos/**", "/auditoria/**", "/buscar-asiento/**",
		        "/clasificar-asiento/**", "/inconsistencias/**", "/validar-cuentas/**", "/estados-financieros/**",
		        "/libro-contable/**", "/exportar-reportes/**", "/reportes-graficos/**", "/importar-excel/**",
		        "/comprobantes/**", "/historial-cambios/**", "/copia-seguridad/**", "/restaurar-bd/**",
		        "/conciliacion/**", "/duplicar-asiento/**", "/inactivar-asiento/**", "/configuracion/**",
		        "/periodos-contables/**")
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/auth/**").permitAll().anyRequest().authenticated())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.exceptionHandling(ex -> ex.authenticationEntryPoint((request, response, authException) -> {
					response.setStatus(401);
					response.setContentType("application/json");
					response.getWriter().write("{\"error\":\"No autorizado\"}");
				})).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	@Order(2)
	public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> auth
			    .requestMatchers("/", "/login", "/css/**", "/js/**", "/favicon.ico").permitAll()
			    .requestMatchers("/dashboard", "/ocr/**").authenticated()
			    .requestMatchers("/web/usuarios/**").hasRole("ADMINISTRADOR")
			    .requestMatchers("/web/auditoria/**").hasAnyRole("ADMINISTRADOR", "AUDITOR")
			    .requestMatchers("/web/respaldos/**").hasRole("ADMINISTRADOR")
			    .requestMatchers("/web/balance/**", "/web/resultados/**", "/web/flujo-caja/**", 
			                     "/web/patrimonio/**", "/web/ratios/**", "/web/costos/**")
			        .hasAnyRole("ADMINISTRADOR", "CONTADOR_GENERAL", "AUDITOR")
			    .anyRequest().authenticated()
			)
				.formLogin(login -> login.loginPage("/login").loginProcessingUrl("/login")
						.successHandler(loginSuccessHandler).failureHandler(loginFailureHandler).permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login").permitAll());
		return http.build();
	}

}