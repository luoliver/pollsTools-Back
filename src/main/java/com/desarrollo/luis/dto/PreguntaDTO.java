package com.desarrollo.luis.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class PreguntaDTO {

	private Integer id;

	@NotBlank
	private String pregunta;
	
	private String descripcion;
	
	private Integer puntaje;
	
	private Boolean multiple;
	
	@NotBlank
	private EncuestaDTO encuesta;
	
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
