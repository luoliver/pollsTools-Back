package com.desarrollo.luis.dto;

public class RespuestaDTO {

	private Integer id;
	
	private String respuesta;
	
	private Boolean opcionCorrecta;

	private PreguntaDTO pregunta;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Boolean getOpcionCorrecta() {
		return opcionCorrecta;
	}

	public void setOpcionCorrecta(Boolean opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}

	public PreguntaDTO getPregunta() {
		return pregunta;
	}

	public void setPregunta(PreguntaDTO pregunta) {
		this.pregunta = pregunta;
	}
	
}
