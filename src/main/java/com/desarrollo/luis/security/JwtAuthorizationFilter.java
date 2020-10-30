package com.desarrollo.luis.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsServiceImpl userService;

	@Autowired
	private JwtService jwtService;

	private static final String HEADER_AUTHORIZATION = "Authorization";
	
	private static final String HEADER_BEARER = "Bearer";
	
	public static final Logger logger = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String authorizationHeader = parseJwt(request);
			if (authorizationHeader != null && jwtService.validateJwtToken(authorizationHeader)) {
				String username = jwtService.extractUsernameFromJwtToken(authorizationHeader);

				UserDetails userDetails = userService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			filterChain.doFilter(request, response);			
		}catch(Exception excepcion) {
			logger.error("No pudo ser autenticado el usuario: {}",excepcion);
		}
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader(HEADER_AUTHORIZATION);
		
		if(StringUtils.hasText(headerAuth) && headerAuth.startsWith(HEADER_BEARER)) {
			return headerAuth.substring(7, headerAuth.length());
		}
		
		return null;
	}

}
