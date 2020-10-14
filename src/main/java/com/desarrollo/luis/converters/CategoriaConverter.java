package com.desarrollo.luis.converters;

import java.util.ArrayList;
import java.util.List;

import com.desarrollo.luis.dto.CategoriaDTO;
import com.desarrollo.luis.model.Categoria;

public class CategoriaConverter {

	public static CategoriaDTO converterModeloADtoSimple(Categoria categoriaAConvertir) {
		CategoriaDTO categoriaConvertido = new CategoriaDTO();
		categoriaConvertido.setId(categoriaAConvertir.getId());
		categoriaConvertido.setCodigo(categoriaAConvertir.getCodigo());
		categoriaConvertido.setDescripcion(categoriaAConvertir.getDescripcion());
		categoriaConvertido.setNombre(categoriaAConvertir.getNombre());
		return categoriaConvertido;
	}

	public static Categoria converterDtoAModeloSimple(CategoriaDTO categoriaAConvertir) {
		Categoria categoriaConvertido = new Categoria();
		categoriaConvertido.setId(categoriaAConvertir.getId());
		categoriaConvertido.setCodigo(categoriaAConvertir.getCodigo());
		categoriaConvertido.setDescripcion(categoriaAConvertir.getDescripcion());
		categoriaConvertido.setNombre(categoriaAConvertir.getNombre());
		return categoriaConvertido;
	}

	public static List<CategoriaDTO> converterListaModeloADtoSimple(List<Categoria> listaCategoriaAConvertir) {
		List<CategoriaDTO> listaCategoriasConvertidos = new ArrayList<>();
		for(Categoria categoriaAConvertir: listaCategoriaAConvertir) {
			listaCategoriasConvertidos.add(converterModeloADtoSimple(categoriaAConvertir));
		}
		return listaCategoriasConvertidos;
	}

	public static List<Categoria> converterListaDtoAModeloSimple(List<CategoriaDTO> listaCategoriaAConvertir) {
		List<Categoria> listaCategoriasConvertidos = new ArrayList<>();
		for(CategoriaDTO categoriaAConvertir: listaCategoriaAConvertir) {
			listaCategoriasConvertidos.add(converterDtoAModeloSimple(categoriaAConvertir));
		}
		return listaCategoriasConvertidos;
	}
	
	public static CategoriaDTO converterModeloADtoCompleto(Categoria categoriaAConvertir) {
		CategoriaDTO categoriaConvertido = converterModeloADtoSimple(categoriaAConvertir);
		if(categoriaAConvertir.getEncuestas() != null)
			categoriaConvertido.setEncuestas(EncuestaConverter.converterListaModeloADtoSimple(categoriaAConvertir.getEncuestas()));
		return categoriaConvertido;
	}

	public static Categoria converterDtoAModeloCompleto(CategoriaDTO categoriaAConvertir) {
		Categoria categoriaConvertido = converterDtoAModeloSimple(categoriaAConvertir);
		if(categoriaAConvertir.getEncuestas() != null)
			categoriaConvertido.setEncuestas(EncuestaConverter.converterListaDtoAModeloSimple(categoriaAConvertir.getEncuestas()));
		return categoriaConvertido;
	}

	public static List<CategoriaDTO> converterListaModeloADtoCompleto(List<Categoria> listaCategoriaAConvertir) {
		List<CategoriaDTO> listaCategoriasConvertidos = new ArrayList<>();
		for(Categoria categoriaAConvertir: listaCategoriaAConvertir) {
			listaCategoriasConvertidos.add(converterModeloADtoCompleto(categoriaAConvertir));
		}
		return listaCategoriasConvertidos;
	}

	public static List<Categoria> converterListaDtoAModeloCompleto(List<CategoriaDTO> listaCategoriaAConvertir) {
		List<Categoria> listaCategoriasConvertidos = new ArrayList<>();
		for(CategoriaDTO categoriaAConvertir: listaCategoriaAConvertir) {
			listaCategoriasConvertidos.add(converterDtoAModeloCompleto(categoriaAConvertir));
		}
		return listaCategoriasConvertidos;
	}
}
