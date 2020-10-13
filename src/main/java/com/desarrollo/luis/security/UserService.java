package com.desarrollo.luis.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desarrollo.luis.controller.IUsuarioService;
import com.desarrollo.luis.dto.UsuarioDTO;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioDTO usuario = usuarioService.consultarPorUsuario(username);
		
		List<GrantedAuthority> roles =  new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(usuario.getRolUsuario().getNombre()));
		UserDetails userDetail = new User(usuario.getUsuario(), usuario.getContrasena(), roles);
		return userDetail;
	}

}
