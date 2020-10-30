package com.desarrollo.luis.controller;

import java.util.List;

import com.desarrollo.luis.dto.CategoriaDTO;

/**
 * Interfaz de controlador para la entidad de categoria
 * 
 * @author 
 */
public interface ICategoriaService {

	/**
	 * Metodo encargado de crear la categoria 
	 * 
	 * @param categoriaDto categoria Dto
	 * @return Categoria Dto con los datos de la creacion
	 */
	public CategoriaDTO crearCategoria(CategoriaDTO categoriaDto);

	/**
	 * Metodo que se encarga de consultar por el codigo de la categoria
	 * 
	 * @param codigo codigo para consultar
	 * @return CategoriaDTo información de la categoria encontrada
	 */
	public CategoriaDTO consultarPorCodigo(String codigo);

	/**
	 * Metodo que se encarga de consultar todas las categorias existentes
	 * 
	 * @return List<CategoriaDTO> lista de categorias a consultar
	 */
	public List<CategoriaDTO> consultarCategorias();

	/**
	 * Metodo que se encarga de modificar una categoria
	 * 
	 * @param categoria categoria a modificar
	 * @return CategoriaDTO Dto con los datos modificacdos
	 */
	public CategoriaDTO modificarCategoria(CategoriaDTO categoria);

}
