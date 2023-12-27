package com.ecommerce.config;

import java.io.*;
import java.util.*;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer.JwtConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTValidator extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException, WeakKeyException {
		String jwt = request.getHeader(JwtConstant.JWT_HEADER);
		
		if(jwt != null) {
			jwt = jwt.substring(7);
			try {
				SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
				Claims claims = Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				
				String email = String.valueOf(claims.get("email"));
				String authorities = String.valueOf(claims.get("authorities"));
				
				List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
				
				Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, auths);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
	
			} catch (Exception e) {
				throw new BadCredentialsException("Invalid token... from jwt validator");
			}
		}
		
		filterChain.doFilter(request, response);
	}
		
}
