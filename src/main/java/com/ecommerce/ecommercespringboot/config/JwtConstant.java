package com.ecommerce.ecommercespringboot.config;
import java.security.Key;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtConstant {

//	public static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	public static final String SECRET_KEY = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

	public static final String JWT_HEADER = "Authorization";
}
