package com.desarrollo.luis.dto;

import java.util.List;

public class RolDTO {

	private int idRol;
	
	private String nombre;
	
	private List<UsuarioDTO> usuario;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioDTO> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<UsuarioDTO> usuario) {
		this.usuario = usuario;
	}

}
