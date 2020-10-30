package com.desarrollo.luis.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Service
public class JwtService {

	private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

	@Value("${pollstools.app.jwtSecret}")
	private String jwtSecret;

	@Value("${pollstools.app.jwtExpirationMs}")
	private String jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl usuarioPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		long fechaExpiracion = new Date().getTime() + Long.parseLong(jwtExpirationMs);
		return Jwts.builder()
				.setSubject(usuarioPrincipal.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(new Date(fechaExpiracion))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String extractUsernameFromJwtToken(String token) {
		return Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}

	public Boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (SignatureException signatureExcepcion) {
			logger.error("Invalid JWT signature: {}", signatureExcepcion.getMessage());
		} catch (MalformedJwtException mailFormedjwtException) {
			logger.error("Invalid JWT token: {}", mailFormedjwtException.getMessage());
		} catch (ExpiredJwtException expiredJwtException) {
			logger.error("JWT token is expired: {}", expiredJwtException.getMessage());
		} catch (UnsupportedJwtException unsupportedJwtException) {
			logger.error("JWT token is unsupported: {}", unsupportedJwtException.getMessage());
		} catch (IllegalArgumentException illegalArgumentException) {
			logger.error("JWT claims string is empty: {}", illegalArgumentException.getMessage());
		}
		return false;	
	}


}
