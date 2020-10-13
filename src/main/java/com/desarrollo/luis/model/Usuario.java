package com.desarrollo.luis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {

	@Id
	@Column(name = "idUsuario")
	private Integer id;
	
	@Column(name = "usuario", length = 50)
	private String usuario;
	
	@Column(name = "contrasena", length = 100)
	private String contrasena;
	
	@Column(name = "primerNombre", length = 50)
	private String primerNombre;
	
	@Column(name = "segundoNombre", length = 50)
	private String segundoNombre;
	
	@Column(name = "primerApellido", length = 50)
	private String primerApellido;
	
	@Column(name = "segundoApellido", length = 50)
	private String segundoApellido;
	
	@Column(name = "genero", length = 1)
	private String genero;
	
	@Column(name="fechaNacimiento")
	private Date fechaNacimiento;
	
	@ManyToOne
	@JoinColumn(name = "idRol")
	private Rol rolUsuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Rol getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(Rol rolUsuario) {
		this.rolUsuario = rolUsuario;
	}
	
}
