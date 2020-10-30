package com.desarrollo.luis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desarrollo.luis.controller.IUsuarioService;
import com.desarrollo.luis.dto.UsuarioDTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private IUsuarioService usuarioService;
	
	@Override
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioDTO usuario = usuarioService.consultarPorUsuario(username);
		return UserDetailsImpl.build(usuario);
	}

}
