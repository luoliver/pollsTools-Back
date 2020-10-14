package com.desarrollo.luis.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoriaDTO {

	@Id
	@Column(name="idCategoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name = "codigo", length = 50, nullable = false)
	private String codigo;
	
	@Column(name = "descripcion", length = 150, nullable = true)
	private String descripcion;
	
	@OneToMany(mappedBy = "categoria")
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
