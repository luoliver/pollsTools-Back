package com.desarrollo.luis.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.luis.controller.ICategoriaService;
import com.desarrollo.luis.converters.CategoriaConverter;
import com.desarrollo.luis.dto.CategoriaDTO;
import com.desarrollo.luis.model.Categoria;
import com.desarrollo.luis.repository.ICategoriaDAO;

@Service
public class CategoriaService implements ICategoriaService{

	@Autowired
	private ICategoriaDAO categoriaDao;
	
	@Override
	public CategoriaDTO crearCategoria(CategoriaDTO categoriaDto)
	{
		if(categoriaDao.existsByCodigo(categoriaDto.getCodigo()))
			return null;
		Categoria categoriaCreada = categoriaDao.save(CategoriaConverter.converterDtoAModeloSimple(categoriaDto));
		return CategoriaConverter.converterModeloADtoSimple(categoriaCreada);
	}
	
	@Override
	public CategoriaDTO consultarPorCodigo(String codigo)
	{
		Categoria categoria = categoriaDao.findByCodigo(codigo);
		if(categoria == null)
			return null;
		return CategoriaConverter.converterModeloADtoSimple(categoria);
	}
	
	@Override
	public List<CategoriaDTO> consultarCategorias()
	{
		List<Categoria> listaCategorias = categoriaDao.findAll();
		if(listaCategorias == null)
			return null;
		return CategoriaConverter.converterListaModeloADtoCompleto(listaCategorias);
	}
	
	@Override
	public CategoriaDTO modificarCategoria(CategoriaDTO categoria) {
		
		if(!categoriaDao.existsById(categoria.getId()))
			return null;
		Categoria categoriaModificada = categoriaDao.save(CategoriaConverter.converterDtoAModeloSimple(categoria));
		return CategoriaConverter.converterModeloADtoSimple(categoriaModificada);
	}
}
