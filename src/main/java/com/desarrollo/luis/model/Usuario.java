package com.desarrollo.luis.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {

	@Id
	@Column(name = "idUsuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "usuario", length = 50, nullable = false)
	private String usuario;

	@Column(name = "contrasena", length = 100, nullable = false)
	private String contrasena;

	@Column(name = "primerNombre", length = 50, nullable = false)
	private String primerNombre;

	@Column(name = "segundoNombre", length = 50)
	private String segundoNombre;

	@Column(name = "primerApellido", length = 50, nullable = false)
	private String primerApellido;

	@Column(name = "segundoApellido", length = 50)
	private String segundoApellido;

	@Column(name = "genero", length = 1, nullable = false)
	private String genero;

	@Column(name="fechaNacimiento", nullable = false)
	private Date fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false)
	private Rol rolUsuario;

	@ManyToMany(mappedBy = "listaUsuariosEncuesta")
	@JsonIgnore
	private List<Encuesta> listaEncuestasUsuario;

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

	public List<Encuesta> getListaEncuestasUsuario() {
		return listaEncuestasUsuario;
	}

	public void setListaEncuestasUsuario(List<Encuesta> listaEncuestasUsuario) {
		this.listaEncuestasUsuario = listaEncuestasUsuario;
	}

}
