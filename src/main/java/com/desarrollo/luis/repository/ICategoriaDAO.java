package com.desarrollo.luis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desarrollo.luis.model.Categoria;

public interface ICategoriaDAO extends JpaRepository<Categoria, Integer>{

	/**
	 * Metodo que se encarga de consultar en la base de datos una categoria segun el codigo
	 * 
	 * @param codigo codigo para realizar la consulta
	 * @return Categoria datos de la categoria encontrada
	 */
	public Categoria findByCodigo(String codigo);
	
	/**
	 * Metodo que se encarga de validar si existe una vategoria con el codigo enviado
	 * 
	 * @param codigo codigo para validar su existencia
	 * @return Boolean true si se encontro, false si no se encontro
	 */
	public Boolean existsByCodigo(String codigo);
}
