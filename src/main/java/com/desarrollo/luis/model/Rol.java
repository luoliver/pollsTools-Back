package com.desarrollo.luis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.desarrollo.luis.enums.EnumRol;

@Entity
public class Rol {

	@Id
	private int idRol;
	
	@Enumerated(EnumType.STRING)
	@Column(name="nombre", length = 50, nullable = false)
	private EnumRol nombre;
	
	@OneToMany(mappedBy = "rolUsuario")
	private List<Usuario> usuario;
	
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

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
}
