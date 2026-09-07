package com.finantel.autenticar_usuario.infraestructura.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.*;
import java.security.KeyStore;
import java.util.Date;

@Component
public class JwtUtil {

    private final PrivateKey privateKey;
    private final PublicKey publicKey;
    private final long EXPIRATION = 86400000;

    public JwtUtil(
            @Value("${app.jwt.keystore}") org.springframework.core.io.Resource keystoreResource,
            @Value("${app.jwt.keystore-password}") String keystorePassword,
            @Value("${app.jwt.key-alias}") String keyAlias) throws Exception {

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(keystoreResource.getInputStream(), keystorePassword.toCharArray());

        this.privateKey = (PrivateKey) keyStore.getKey(keyAlias, keystorePassword.toCharArray());
        this.publicKey = keyStore.getCertificate(keyAlias).getPublicKey();
    }

    public String generateToken(String email, String rol) {
        return Jwts.builder()
            .setSubject(email)
            .claim("rol", rol)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(privateKey, SignatureAlgorithm.RS512)
            .compact();
    }

    public String getEmail(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(publicKey)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean isValid(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}