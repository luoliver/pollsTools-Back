package com.desarrollo.luis.dto;

import java.util.List;

import com.desarrollo.luis.enums.EnumRol;

public class RolDTO {

	private int idRol;
	
	private EnumRol nombre;
	
	private List<UsuarioDTO> usuario;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public EnumRol getNombre() {
		return nombre;
	}

	public void setNombre(EnumRol nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioDTO> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<UsuarioDTO> usuario) {
		this.usuario = usuario;
	}

}
