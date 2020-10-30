package com.desarrollo.luis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.luis.model.Pregunta;
import com.desarrollo.luis.model.Respuesta;

public interface IRespuestaDAO extends JpaRepository<Respuesta, Integer>{

	/**
	 * Metodo que se encarga de consultar las respuestas de una pregunta
	 * 
	 * @param pregunta pregunta a consultar las respuestas
	 * @return  List<Respuesta> lista de respuestas encontradas a la pregunta
	 */
	public List<Respuesta> findByPregunta(Pregunta pregunta);

}
