package com.desarrollo.luis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.luis.model.Categoria;
import com.desarrollo.luis.model.Encuesta;

public interface IEncuestaDAO extends JpaRepository<Encuesta, Integer>{

	public Boolean existsByCodigo(String codigo);
	
	public List<Encuesta> findByCategoria(Categoria categoria);

	public Encuesta findByCodigo(String codigo);

}
