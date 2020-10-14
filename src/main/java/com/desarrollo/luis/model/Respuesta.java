package com.desarrollo.luis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Respuesta {

	@Id
	@Column(name = "idRespuesta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "respuesta", length = 150, nullable = false)
	private String respuesta;
	
	@Column(name = "opcionCorrecta", nullable = false)
	private Boolean opcionCorrecta;

	@ManyToOne
	@JoinColumn(name = "idPregunta", nullable = false)
	private Pregunta pregunta;
	
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

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
}
