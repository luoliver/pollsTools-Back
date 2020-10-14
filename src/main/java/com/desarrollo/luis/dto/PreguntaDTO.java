package com.desarrollo.luis.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PreguntaDTO {

	@Id
	@Column(name = "idPregunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "pregunta", length = 50, nullable = false)
	private String pregunta;
	
	@Column(name = "descripcion", length = 150, nullable = false)
	private String descripcion;
	
	@Column(name = "puntaje", nullable = true)
	private Integer puntaje;
	
	@Column(name = "multiple", nullable = false)
	private Boolean multiple;
	
	@ManyToOne
	@JoinColumn(name = "idEncuesta", nullable = false)
	private EncuestaDTO encuesta;
	
	@OneToMany(mappedBy = "pregunta")
	private List<RespuestaDTO> respuestas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	public EncuestaDTO getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(EncuestaDTO encuesta) {
		this.encuesta = encuesta;
	}

	public List<RespuestaDTO> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<RespuestaDTO> respuestas) {
		this.respuestas = respuestas;
	}
	
}
