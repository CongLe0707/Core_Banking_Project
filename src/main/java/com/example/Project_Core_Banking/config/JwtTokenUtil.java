package com.example.Project_Core_Banking.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {
    // Nên để ít nhất 32 ký tự để đảm bảo >= 256-bit
    private final String SECRET_KEY = "L3zZVbMth3F+KzHJtLSPmq7E97Q2XpM1cJ0lN6HugfY=";

    private final long ACCESS_TOKEN_VALIDITY = 15 * 60 * 1000; // 15 phút
    private final long REFRESH_TOKEN_VALIDITY = 7 * 24 * 60 * 60 * 1000L; // 7 ngày

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String clientNo, String role, boolean isRefreshToken) {
        long expiration = isRefreshToken ? REFRESH_TOKEN_VALIDITY : ACCESS_TOKEN_VALIDITY;
        return Jwts.builder()
                .setSubject(clientNo)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateAccessToken(String clientNo, String role) {
        return generateToken(clientNo, role, false);
    }

    public String generateRefreshToken(String clientNo, String role) {
        return generateToken(clientNo, role, true);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.print("ehehee " + e.getMessage());
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}