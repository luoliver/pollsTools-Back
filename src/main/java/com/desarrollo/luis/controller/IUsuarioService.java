package com.desarrollo.luis.controller;

import java.util.List;

import com.desarrollo.luis.dto.UsuarioDTO;

public interface IUsuarioService {

	public UsuarioDTO consultarPorUsuario(String usuario);
	
	public UsuarioDTO crearUsuario(UsuarioDTO usuario);
	
	public List<UsuarioDTO> consultarUsuarios();
	
}
