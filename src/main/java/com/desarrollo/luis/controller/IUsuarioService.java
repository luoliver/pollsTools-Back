package com.desarrollo.luis.controller;

import java.util.List;

import com.desarrollo.luis.dto.UsuarioDTO;

public interface IUsuarioService {

	public UsuarioDTO consultarPorUsuario(String usuario);
	
	public UsuarioDTO crearUsuarioAdminsitrador(UsuarioDTO usuario);
	
	public UsuarioDTO crearUsuario(UsuarioDTO usuario);
	
	public UsuarioDTO modificarUsuario(UsuarioDTO usuario);
	
	public List<UsuarioDTO> consultarUsuarios();
	
	public Boolean eliminarUsuario(Integer id);
}
