package com.desarrollo.luis.converters;

import java.util.ArrayList;
import java.util.List;

import com.desarrollo.luis.dto.PreguntaDTO;
import com.desarrollo.luis.model.Pregunta;

public class PreguntaConverter {

	public static PreguntaDTO converterModeloADtoSimple(Pregunta preguntaAConvertir) {
		PreguntaDTO preguntaConvertido = new PreguntaDTO();
		preguntaConvertido.setId(preguntaAConvertir.getId());
		preguntaConvertido.setPregunta(preguntaAConvertir.getPregunta());
		preguntaConvertido.setDescripcion(preguntaAConvertir.getDescripcion());
		preguntaConvertido.setMultiple(preguntaAConvertir.getMultiple());
		preguntaConvertido.setPuntaje(preguntaAConvertir.getPuntaje());
		return preguntaConvertido;
	}

	public static Pregunta converterDtoAModeloSimple(PreguntaDTO preguntaAConvertir) {
		Pregunta preguntaConvertido = new Pregunta();
		preguntaConvertido.setId(preguntaAConvertir.getId());
		preguntaConvertido.setPregunta(preguntaAConvertir.getPregunta());
		preguntaConvertido.setDescripcion(preguntaAConvertir.getDescripcion());
		preguntaConvertido.setMultiple(preguntaAConvertir.getMultiple());
		preguntaConvertido.setPuntaje(preguntaAConvertir.getPuntaje());
		return preguntaConvertido;
	}

	public static List<PreguntaDTO> converterListaModeloADtoSimple(List<Pregunta> listaPreguntaAConvertir) {
		List<PreguntaDTO> listaPreguntasConvertidos = new ArrayList<>();
		for(Pregunta preguntaAConvertir: listaPreguntaAConvertir) {
			listaPreguntasConvertidos.add(converterModeloADtoSimple(preguntaAConvertir));
		}
		return listaPreguntasConvertidos;
	}

	public static List<Pregunta> converterListaDtoAModeloSimple(List<PreguntaDTO> listaPreguntaAConvertir) {
		List<Pregunta> listaPreguntasConvertidos = new ArrayList<>();
		for(PreguntaDTO preguntaAConvertir: listaPreguntaAConvertir) {
			listaPreguntasConvertidos.add(converterDtoAModeloSimple(preguntaAConvertir));
		}
		return listaPreguntasConvertidos;
	}
	
	public static PreguntaDTO converterModeloADtoCompleto(Pregunta preguntaAConvertir) {
		PreguntaDTO preguntaConvertido = converterModeloADtoSimple(preguntaAConvertir);
		if(preguntaAConvertir.getEncuesta() != null)
			preguntaConvertido.setEncuesta(EncuestaConverter.converterModeloADtoSimple(preguntaAConvertir.getEncuesta()));
		if(preguntaAConvertir.getRespuestas() != null)
			preguntaConvertido.setRespuestas(RespuestaConverter.converterListaModeloADtoSimple(preguntaAConvertir.getRespuestas()));
		return preguntaConvertido;
	}

	public static Pregunta converterDtoAModeloCompleto(PreguntaDTO preguntaAConvertir) {
		Pregunta preguntaConvertido = converterDtoAModeloSimple(preguntaAConvertir);
		if(preguntaAConvertir.getEncuesta() != null)
			preguntaConvertido.setEncuesta(EncuestaConverter.converterDtoAModeloSimple(preguntaAConvertir.getEncuesta()));
		if(preguntaAConvertir.getRespuestas() != null)
			preguntaConvertido.setRespuestas(RespuestaConverter.converterListaDtoAModeloSimple(preguntaAConvertir.getRespuestas()));
		return preguntaConvertido;
	}

	public static List<PreguntaDTO> converterListaModeloADtoCompleto(List<Pregunta> listaPreguntaAConvertir) {
		List<PreguntaDTO> listaPreguntasConvertidos = new ArrayList<>();
		for(Pregunta preguntaAConvertir: listaPreguntaAConvertir) {
			listaPreguntasConvertidos.add(converterModeloADtoCompleto(preguntaAConvertir));
		}
		return listaPreguntasConvertidos;
	}

	public static List<Pregunta> converterListaDtoAModeloCompleto(List<PreguntaDTO> listaPreguntaAConvertir) {
		List<Pregunta> listaPreguntasConvertidos = new ArrayList<>();
		for(PreguntaDTO preguntaAConvertir: listaPreguntaAConvertir) {
			listaPreguntasConvertidos.add(converterDtoAModeloCompleto(preguntaAConvertir));
		}
		return listaPreguntasConvertidos;
	}
}
