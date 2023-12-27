package com.ecommerce.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTProvider {

	public String generateToken(Authentication auth) {
		SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
		String token = Jwts.builder()
                      .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+846000000))
                      .claim("email", auth.getName()).signWith(key).compact();
		return token;
    }
	
	public String getEmailFromToken(String token) {
		token = token.substring(7);
		SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
		Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
		String email = String.valueOf(claims.get("email"));
		return email;
	}
}
