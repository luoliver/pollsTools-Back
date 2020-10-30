package com.desarrollo.luis.dto;

import java.util.Date;
import java.util.List;

public class UsuarioDTO {

	private Integer id;
	
	private String usuario;
	
	private String contrasena;
	
	private String primerNombre;
	
	private String segundoNombre;
	
	private String primerApellido;
	
	private String segundoApellido;
	
	private String genero;
	
	private Date fechaNacimiento;
	
	private RolDTO rolUsuario;
	
	private List<EncuestaDTO> listaEncuestas;

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

	public RolDTO getRolUsuario() {
		return rolUsuario;
	}

	public void setRolUsuario(RolDTO rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	public List<EncuestaDTO> getListaEncuestas() {
		return listaEncuestas;
	}

	public void setListaEncuestas(List<EncuestaDTO> listaEncuestas) {
		this.listaEncuestas = listaEncuestas;
	}
	
}
