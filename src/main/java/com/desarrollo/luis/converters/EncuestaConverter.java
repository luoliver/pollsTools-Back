package com.desarrollo.luis.converters;

import java.util.ArrayList;
import java.util.List;

import com.desarrollo.luis.dto.EncuestaDTO;
import com.desarrollo.luis.model.Encuesta;

public class EncuestaConverter {

	public static EncuestaDTO converterModeloADtoSimple(Encuesta encuestaAConvertir) {
		EncuestaDTO encuestaConvertido = new EncuestaDTO();
		encuestaConvertido.setId(encuestaAConvertir.getId());
		encuestaConvertido.setCodigo(encuestaAConvertir.getCodigo());
		encuestaConvertido.setDescripcion(encuestaAConvertir.getDescripcion());
		encuestaConvertido.setNombre(encuestaAConvertir.getNombre());
		return encuestaConvertido;
	}

	public static Encuesta converterDtoAModeloSimple(EncuestaDTO encuestaAConvertir) {
		Encuesta encuestaConvertido = new Encuesta();
		encuestaConvertido.setId(encuestaAConvertir.getId());
		encuestaConvertido.setId(encuestaAConvertir.getId());
		encuestaConvertido.setCodigo(encuestaAConvertir.getCodigo());
		encuestaConvertido.setDescripcion(encuestaAConvertir.getDescripcion());
		encuestaConvertido.setNombre(encuestaAConvertir.getNombre());
		return encuestaConvertido;
	}

	public static List<EncuestaDTO> converterListaModeloADtoSimple(List<Encuesta> listaEncuestaAConvertir) {
		List<EncuestaDTO> listaEncuestasConvertidos = new ArrayList<>();
		for(Encuesta encuestaAConvertir: listaEncuestaAConvertir) {
			listaEncuestasConvertidos.add(converterModeloADtoSimple(encuestaAConvertir));
		}
		return listaEncuestasConvertidos;
	}

	public static List<Encuesta> converterListaDtoAModeloSimple(List<EncuestaDTO> listaEncuestaAConvertir) {
		List<Encuesta> listaEncuestasConvertidos = new ArrayList<>();
		for(EncuestaDTO encuestaAConvertir: listaEncuestaAConvertir) {
			listaEncuestasConvertidos.add(converterDtoAModeloSimple(encuestaAConvertir));
		}
		return listaEncuestasConvertidos;
	}
	
	public static EncuestaDTO converterModeloADtoCompleto(Encuesta encuestaAConvertir) {
		EncuestaDTO encuestaConvertido = converterModeloADtoSimple(encuestaAConvertir);
		if(encuestaAConvertir.getPreguntas() != null)
			encuestaConvertido.setPreguntas(PreguntaConverter.converterListaModeloADtoCompleto(encuestaAConvertir.getPreguntas()));
		if(encuestaAConvertir.getCategoria() != null)
			encuestaConvertido.setCategoria(CategoriaConverter.converterModeloADtoSimple(encuestaAConvertir.getCategoria()));
		return encuestaConvertido;
	}

	public static Encuesta converterDtoAModeloCompleto(EncuestaDTO encuestaAConvertir) {
		Encuesta encuestaConvertido = converterDtoAModeloSimple(encuestaAConvertir);
		if(encuestaAConvertir.getPreguntas() != null)
			encuestaConvertido.setPreguntas(PreguntaConverter.converterListaDtoAModeloCompleto(encuestaAConvertir.getPreguntas()));
		if(encuestaAConvertir.getCategoria() != null)
			encuestaConvertido.setCategoria(CategoriaConverter.converterDtoAModeloSimple(encuestaAConvertir.getCategoria()));
		return encuestaConvertido;
	}

	public static List<EncuestaDTO> converterListaModeloADtoCompleto(List<Encuesta> listaEncuestaAConvertir) {
		List<EncuestaDTO> listaEncuestasConvertidos = new ArrayList<>();
		for(Encuesta encuestaAConvertir: listaEncuestaAConvertir) {
			listaEncuestasConvertidos.add(converterModeloADtoCompleto(encuestaAConvertir));
		}
		return listaEncuestasConvertidos;
	}

	public static List<Encuesta> converterListaDtoAModeloCompleto(List<EncuestaDTO> listaEncuestaAConvertir) {
		List<Encuesta> listaEncuestasConvertidos = new ArrayList<>();
		for(EncuestaDTO encuestaAConvertir: listaEncuestaAConvertir) {
			listaEncuestasConvertidos.add(converterDtoAModeloCompleto(encuestaAConvertir));
		}
		return listaEncuestasConvertidos;
	}
}
