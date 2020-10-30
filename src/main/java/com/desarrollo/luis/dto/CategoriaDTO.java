package com.desarrollo.luis.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

	private Integer id;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String codigo;
	
	private String descripcion;
	
	private List<EncuestaDTO> encuestas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<EncuestaDTO> getEncuestas() {
		return encuestas;
	}

	public void setEncuestas(List<EncuestaDTO> encuestas) {
		this.encuestas = encuestas;
	}
	
}
