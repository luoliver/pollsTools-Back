package com.desarrollo.luis.controller;

import java.util.List;

import com.desarrollo.luis.dto.PreguntaDTO;
import com.desarrollo.luis.dto.RespuestaDTO;

public interface IRespuestaService {

	/**
	 * Metodo que se encarga de crear las respuestas y guardar en base de datos
	 * 
	 * @param respuesta datos de la respuesta a crear
	 * @return RespuestaDTO datos de la respuesta creada
	 */
	public RespuestaDTO crearRespuesta(RespuestaDTO respuesta);

	/**
	 * Metodo que consulta las respuestas segun la pregunta que se realice
	 * 
	 * @param preguntaDto pregunta a la que se le desea sacar las respuestas
	 * @return List<RespuestaDTO> lista de respuestas de la pregunta
	 */
	public List<RespuestaDTO> consultarRespuestaPorPregunta(PreguntaDTO preguntaDto);

}
