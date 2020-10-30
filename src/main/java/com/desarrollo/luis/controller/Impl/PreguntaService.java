package com.desarrollo.luis.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollo.luis.controller.IPreguntaService;
import com.desarrollo.luis.converters.EncuestaConverter;
import com.desarrollo.luis.converters.PreguntaConverter;
import com.desarrollo.luis.dto.EncuestaDTO;
import com.desarrollo.luis.dto.PreguntaDTO;
import com.desarrollo.luis.model.Pregunta;
import com.desarrollo.luis.repository.IPreguntaDAO;

@Service
public class PreguntaService implements IPreguntaService{

	@Autowired
	private IPreguntaDAO preguntaDao;
	
	@Override
	public PreguntaDTO crearPregunta(PreguntaDTO preguntaDto) {
		Pregunta preguntaAConvertir = preguntaDao.save(PreguntaConverter.converterDtoAModeloCompleto(preguntaDto));
		return PreguntaConverter.converterModeloADtoSimple(preguntaAConvertir);
	}
	
	@Override
	public List<PreguntaDTO> consultarPreguntasPorEncuesta(EncuestaDTO encuestaDto){
		List<Pregunta> listaPreguntas = preguntaDao.findByEncuesta(EncuestaConverter.converterDtoAModeloSimple(encuestaDto));
		if(listaPreguntas.isEmpty())
			return null;
		return PreguntaConverter.converterListaModeloADtoSimple(listaPreguntas);
	}
	
	@Override
	public Long cantidadRespuestasPorPregunta(EncuestaDTO encuestaDto) {
		return preguntaDao.countByEncuesta(EncuestaConverter.converterDtoAModeloSimple(encuestaDto));
	}
}
