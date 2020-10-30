package com.desarrollo.luis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desarrollo.luis.model.Encuesta;
import com.desarrollo.luis.model.Pregunta;

public interface IPreguntaDAO extends JpaRepository<Pregunta, Integer>{

	/**
	 * Metodo que se encarga de consultar en BD las preguntas que pertenecen a una encuesta
	 * 
	 * @param encuesta datos de la encuesta a consultar
	 * @return List<Pregunta> lista de preguntas encontradas para la encuesta
	 */
	public List<Pregunta> findByEncuesta(Encuesta encuesta);

	/**
	 * Metodo que se encarga de consultar cuantas preguntas tiene una encuesta
	 * 
	 * @param encuesta encuesta para ver cuantas preguntas tiene
	 * @return Long cantidad de respuestas encontradas
	 */
	 @Query("SELECT COUNT(u) FROM Pregunta u WHERE u.encuesta=:encuesta")
	 public Long countByEncuesta(@Param("encuesta") Encuesta encuesta);

}
