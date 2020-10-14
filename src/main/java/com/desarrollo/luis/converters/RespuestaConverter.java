package com.desarrollo.luis.converters;

import java.util.ArrayList;
import java.util.List;

import com.desarrollo.luis.dto.RespuestaDTO;
import com.desarrollo.luis.model.Respuesta;

public class RespuestaConverter {

	public static RespuestaDTO converterModeloADtoSimple(Respuesta respuestaAConvertir) {
		RespuestaDTO respuestaConvertido = new RespuestaDTO();
		respuestaConvertido.setId(respuestaAConvertir.getId());
		respuestaConvertido.setOpcionCorrecta(respuestaAConvertir.getOpcionCorrecta());
		respuestaConvertido.setRespuesta(respuestaAConvertir.getRespuesta());
		respuestaConvertido.setRespuesta(respuestaAConvertir.getRespuesta());
		return respuestaConvertido;
	}

	public static Respuesta converterDtoAModeloSimple(RespuestaDTO respuestaAConvertir) {
		Respuesta respuestaConvertido = new Respuesta();
		respuestaConvertido.setId(respuestaAConvertir.getId());
		respuestaConvertido.setOpcionCorrecta(respuestaAConvertir.getOpcionCorrecta());
		respuestaConvertido.setRespuesta(respuestaAConvertir.getRespuesta());
		respuestaConvertido.setRespuesta(respuestaAConvertir.getRespuesta());
		return respuestaConvertido;
	}

	public static List<RespuestaDTO> converterListaModeloADtoSimple(List<Respuesta> listaRespuestaAConvertir) {
		List<RespuestaDTO> listaRespuestasConvertidos = new ArrayList<>();
		for(Respuesta respuestaAConvertir: listaRespuestaAConvertir) {
			listaRespuestasConvertidos.add(converterModeloADtoSimple(respuestaAConvertir));
		}
		return listaRespuestasConvertidos;
	}

	public static List<Respuesta> converterListaDtoAModeloSimple(List<RespuestaDTO> listaRespuestaAConvertir) {
		List<Respuesta> listaRespuestasConvertidos = new ArrayList<>();
		for(RespuestaDTO respuestaAConvertir: listaRespuestaAConvertir) {
			listaRespuestasConvertidos.add(converterDtoAModeloSimple(respuestaAConvertir));
		}
		return listaRespuestasConvertidos;
	}
	
	public static RespuestaDTO converterModeloADtoCompleto(Respuesta respuestaAConvertir) {
		RespuestaDTO respuestaConvertido = converterModeloADtoSimple(respuestaAConvertir);
		if(respuestaAConvertir.getPregunta() != null)
			respuestaConvertido.setPregunta(PreguntaConverter.converterModeloADtoSimple(respuestaAConvertir.getPregunta()));
		return respuestaConvertido;
	}

	public static Respuesta converterDtoAModeloCompleto(RespuestaDTO respuestaAConvertir) {
		Respuesta respuestaConvertido = converterDtoAModeloSimple(respuestaAConvertir);
		if(respuestaAConvertir.getPregunta() != null)
			respuestaConvertido.setPregunta(PreguntaConverter.converterDtoAModeloSimple(respuestaAConvertir.getPregunta()));
		return respuestaConvertido;
	}

	public static List<RespuestaDTO> converterListaModeloADtoCompleto(List<Respuesta> listaRespuestaAConvertir) {
		List<RespuestaDTO> listaRespuestasConvertidos = new ArrayList<>();
		for(Respuesta respuestaAConvertir: listaRespuestaAConvertir) {
			listaRespuestasConvertidos.add(converterModeloADtoCompleto(respuestaAConvertir));
		}
		return listaRespuestasConvertidos;
	}

	public static List<Respuesta> converterListaDtoAModeloCompleto(List<RespuestaDTO> listaRespuestaAConvertir) {
		List<Respuesta> listaRespuestasConvertidos = new ArrayList<>();
		for(RespuestaDTO respuestaAConvertir: listaRespuestaAConvertir) {
			listaRespuestasConvertidos.add(converterDtoAModeloCompleto(respuestaAConvertir));
		}
		return listaRespuestasConvertidos;
	}
}
