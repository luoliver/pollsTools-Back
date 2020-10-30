package com.desarrollo.luis.controller;

import java.util.List;

import com.desarrollo.luis.dto.EncuestaDTO;
import com.desarrollo.luis.dto.PreguntaDTO;

public interface IPreguntaService {

	/**
	 * Metodo que se encarga de crear una pregunta
	 * 
	 * @param preguntaDto datos de la pregunta a crear
	 * @return PReguntaDTO con los datos de la pregunta creada
	 */
	public PreguntaDTO crearPregunta(PreguntaDTO preguntaDto);

	/**
	 * Metodo que se encarga de consultar las preguntas de una encuesta
	 * 
	 * @param encuestaDto datos de la encuesta a consultar las preguntas
	 * @return List<PreguntaDTO> lista de preguntas encontradas para la encuesta
	 */
	public List<PreguntaDTO> consultarPreguntasPorEncuesta(EncuestaDTO encuestaDto);

	/**
	 * Metodo que se encarga de consultar la cantidad de preguntas de una encuesta
	 * 
	 * @param encuesta para contar las preguntas que tiene
	 * @return Long cantidad de respuestas creadas para la pregunta
	 */
	public Long cantidadRespuestasPorPregunta(EncuestaDTO encuesta);	

}
