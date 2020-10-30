package com.desarrollo.luis.controller;

import java.util.List;

import com.desarrollo.luis.dto.CategoriaDTO;
import com.desarrollo.luis.dto.EncuestaDTO;

public interface IEncuestaService {

	/**
	 * Metodo que se encarga de crear una encuesta
	 * 
	 * @param encuestaDto datos de la encuesta a crear
	 * @return EncuestaDTO con los datos de la creacion y el ID autogenerado
	 */
	public EncuestaDTO crearEncuesta(EncuestaDTO encuestaDto);

	/**
	 * Metodo que se encarga de consultar las encuestas que existen en BD
	 * 
	 * @return List<EncuestaDTO> lista de encuestas en DTO encontradas en la BD
	 */
	public List<EncuestaDTO> listarEncuestas();

	/**
	 * Metodo que permite consultar las encuestas asociadas a una categoria
	 * 
	 * @param categoriaDto categoria para consultar las encuestas
	 * @return List<EncuestaDTO> lista de encuestas encontradas en la categoria
	 */
	public List<EncuestaDTO> listarEncuestaPorCategoria(CategoriaDTO categoriaDto);

	/**
	 * Metodo que se encarga de traer la cantidad de preguntas que tiene una encuesta
	 * 
	 * @param encuestaDto encuesta a la que se le consulta la cantidad de preguntas
	 * @return Integer cantidad de preguntas encontradas
	 */
	public Integer cantidadPreguntasEncuesta(EncuestaDTO encuestaDto);

	/**
	 * Metodo que se encarga de consultar una encuesta por el codigo
	 * 
	 * @param codigo por el que se va a consultar en BD
	 * @return EncuestaDTO datos de la encuesta encontrada
	 */
	public EncuestaDTO consultarEncuestaPorCodigo(String codigo);

}
